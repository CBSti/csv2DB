package de.peterspan.csv2db.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.SwingWorker;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;

import de.peterspan.csv2db.AppWindow;
import de.peterspan.csv2db.domain.LocationDAOImpl;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;
import de.peterspan.csv2db.util.ApplicationContextLoader;

@Component
public class LocationConverter extends SwingWorker<Void, Void> {

	@Autowired
	private ApplicationContext applicationContext;

	@Resource
	SessionFactory sessionFactory;

	@Resource
	LocationDAOImpl locationDao;

	File inputFile;

	public LocationConverter() {
	};

	public LocationConverter(File inputFile) {
		super();
		URL resource = AppWindow.class.getResource("app-config.xml");
		new ApplicationContextLoader().load(this, resource.toString());
		this.inputFile = inputFile;
	}

	public void readLine(String[] line, Session session) {
		LocationDataLine datasetLine = new LocationDataLine(line);

		Location loc = datasetLine.getLocation();
		session.saveOrUpdate(loc);
	}

	@Override
	protected Void doInBackground() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
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

			int modFactor = (int) (allLines.size() / 100);
			int counter = 0;
			int progress = 0;
			// Removing the heaser
			// Remove the empty line
			for (String[] line : allLines) {
				counter = counter + 1;
				if (line[0].equals("Standort-Nr.")) {
					continue;
				}
				if (line[0].equals("")) {
					continue;
				}
				readLine(line, session);
				// if(counter%modFactor == 0){
				// setProgress(progress+1);
				// }

			}

			session.flush();
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void done() {
		firePropertyChange("done", false, true);
	}
}
