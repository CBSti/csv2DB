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
import java.util.List;

import javax.persistence.EntityTransaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

public class Converter extends AbstractConverter {

	private static final Log log = LogFactory.getLog(Converter.class);
	
	public Converter() {
		super();
	};

	public Converter(File inputFile) {
		super(inputFile);

	}

	public void readLine(String[] line) {
		DatasetLine datasetLine = new DatasetLine(line);
		if(!datasetLine.isValid()){
			return;
		}
		DataSet dataset = datasetLine.getDataset();
		
		if (dataset != null) {
			entityManager.persist(dataset);

			Location loc = datasetLine.getLocation();
			
			Location sessionLoc = locationDao.getByLocationNumber(entityManager, loc.getLocationNumber());
			
			if(sessionLoc != null) {
				dataset.setLocation(sessionLoc);
				entityManager.refresh(dataset);
			} else {
				entityManager.persist(loc);
				dataset.setLocation(loc);
			}
			
			
			MeasurementValues values = datasetLine.getValues();
			
			dataset.setInputError(datasetLine.getInputErrors());
			
			entityManager.persist(values);

			dataset.setMeasurementValues(values);
			entityManager.refresh(dataset);
		}

	}

	@Override
	protected Void doInBackground() throws Exception {
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			List<String[]> allLines = readFile();

			double increment = 100.0 / allLines.size();
			double progress = 0.0;
			for (String[] line : allLines) {
				progress = progress + increment;
				setProgress((int) Math.round(progress));

				if (line[0].equals("locnumber")) {
					//This is the header! Create a single instance header object
					Header.getInstance().init(line);
					continue;
				}
				if (line[0].equals("")) {
					continue;
				}
				readLine(line);
			}


			entityManager.flush();
			tx.commit();
			
		} catch (HibernateException he) {
			log.error("An error occured. Tx will be rolledback!", he);
			if (tx != null) {
				tx.rollback();
			}
		} 
		
		return null;
	}

}
