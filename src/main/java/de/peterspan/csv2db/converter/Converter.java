package de.peterspan.csv2db.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.SwingWorker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;
import de.peterspan.csv2db.AppWindow;
import de.peterspan.csv2db.DatasetLine;
import de.peterspan.csv2db.domain.DatasetDAOImpl;
import de.peterspan.csv2db.domain.LocationDAOImpl;
import de.peterspan.csv2db.domain.MeasurementValuesDAOImpl;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.util.ApplicationContextLoader;

@Component
public class Converter extends SwingWorker<Void, Void> {

	@Autowired
	private ApplicationContext applicationContext;

	@Resource
	SessionFactory sessionFactory;

	@Resource
	LocationDAOImpl locationDao;

	@Resource
	DatasetDAOImpl datasetDao;

	@Resource
	MeasurementValuesDAOImpl valuesDao;

	File inputFile;

	public Converter() {
	};

	public Converter(File inputFile) {
		super();
		URL resource = AppWindow.class.getResource("./app-config.xml");
		new ApplicationContextLoader().load(this, resource.toString());
		this.inputFile = inputFile;
	}

	public void readLine(String[] line, Session session){
		DatasetLine datasetLine = new DatasetLine(line);
		DataSet dataset = datasetLine.getDataset();
		
		session.saveOrUpdate(dataset);
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		FileReader fileReader = null;
		CSVReader csvReader = null;
		List<String[]> allLines = new ArrayList<String[]>();
		try {
			fileReader = new FileReader(inputFile);
			csvReader = new CSVReader(fileReader, ';');
			allLines = csvReader.readAll();
		} catch (IOException ioe) {

		} finally {
			if (csvReader != null)
				csvReader.close();
			if (fileReader != null)
				fileReader.close();
		}

		firePropertyChange("readingLines", false, true);
		
		
		int modFactor = (int)(allLines.size()/100);
		int counter = 0;
		int progress = 0;
		
		for(String[] line:allLines){
			counter = counter +1;
			readLine(line, session);
			if(counter%modFactor == 0){
				setProgress(progress+1);
			}
			
		}
		
		session.flush();
		tx.commit();
		session.close();
		return null;
	}

	@Override
	public void done() {
		firePropertyChange("done", false, true);
	}
}
