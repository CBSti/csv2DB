package de.peterspan.csv2db.converter;

import java.io.File;
import java.net.URL;

import javax.annotation.Resource;
import javax.swing.SwingWorker;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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
