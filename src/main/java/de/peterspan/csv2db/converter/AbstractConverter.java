/**
 *  Copyright 2012-2013 Frederik Hahne, Christoph Stiehm
 *
 * 	This file is part of csv2db.
 *
 *  csv2db is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  csv2db is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with csv2db.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.peterspan.csv2db.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.SwingWorker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import au.com.bytecode.opencsv.CSVReader;
import de.peterspan.csv2db.AppWindow;
import de.peterspan.csv2db.domain.DatasetDAOImpl;
import de.peterspan.csv2db.domain.LocationDAOImpl;
import de.peterspan.csv2db.domain.MeasurementValuesDAOImpl;
import de.peterspan.csv2db.util.ApplicationContextLoader;

public abstract class AbstractConverter extends SwingWorker<Void, Void> {

	private static final Log log = LogFactory.getLog(AbstractConverter.class);
	
	@Autowired
	protected ApplicationContext applicationContext;

	@Resource
	protected EntityManagerFactory entityManagerFactory;
	
	protected EntityManager entityManager;

	@Resource
	protected LocationDAOImpl locationDao;

	@Resource
	protected DatasetDAOImpl datasetDao;

	@Resource
	protected MeasurementValuesDAOImpl valuesDao;

	protected File inputFile;

	public AbstractConverter(){
		
	}
	
	public AbstractConverter(File inputFile) {
		super();
		injectContext();
		this.inputFile = inputFile;
		entityManager = entityManagerFactory.createEntityManager();
	}

	public abstract void readLine(String[] line);

	void injectContext() {
		URL resource = AppWindow.class.getResource("app-config.xml");
		new ApplicationContextLoader().load(this, resource.toString());
	}

	protected List<String[]> readFile() throws Exception {
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<String[]> allLines = new ArrayList<String[]>();
		try {
			fileReader = new FileReader(inputFile);
			csvReader = new CSVReader(fileReader, ';');
			allLines = csvReader.readAll();
		} catch (IOException ioe) {
			log.error("An error occured while trying to read the input file.", ioe);
		} finally {
			if (csvReader != null)
				csvReader.close();
			if (fileReader != null)
				fileReader.close();
		}

		firePropertyChange("readingLines", false, true);

		return allLines;
	}

	@Override
	public void done() {
		firePropertyChange("done", false, true);
	}
}
