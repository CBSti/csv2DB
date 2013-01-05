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
public class LocationConverter extends AbstractConverter {

	public LocationConverter() {
		super();
	};

	public LocationConverter(File inputFile) {
		super(inputFile);
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
			List<String[]> allLines = readFile();

			double increment = 100.0 / allLines.size();
			double progress = 0.0;
			// Removing the header
			// Remove the empty line
			for (String[] line : allLines) {
				progress = progress + increment;
				setProgress((int) Math.round(progress));
				if (line[0].equals("Standort-Nr.")) {
					continue;
				}
				if (line[0].equals("")) {
					continue;
				}
				readLine(line, session);

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

}
