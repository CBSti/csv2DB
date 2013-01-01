package de.peterspan.csv2db.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.SwingWorker;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;
import de.peterspan.csv2db.AppWindow;
import de.peterspan.csv2db.domain.DatasetDAOImpl;
import de.peterspan.csv2db.domain.LocationDAOImpl;
import de.peterspan.csv2db.domain.MeasurementValuesDAOImpl;
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

	@Override
	protected Void doInBackground() throws Exception {
		setProgress(1);
		FileReader fileReader = null;
		CSVReader csvReader = null;
		try {
			fileReader = new FileReader(inputFile);
			csvReader = new CSVReader(fileReader, ';');
			List<String[]> allLines = csvReader.readAll();
		} catch (IOException ioe) {

		} finally {
			if (csvReader != null)
				csvReader.close();
			if (fileReader != null)
				fileReader.close();
		}

		for (int i = 1; i <= 100; i++) {
			setProgress(i);
			Thread.sleep(150);
		}
		return null;
	}

	@Override
	public void done() {
		firePropertyChange("done", false, true);
	}
}
