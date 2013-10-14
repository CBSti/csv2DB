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
package de.peterspan.csv2db.converter.location;

import java.io.File;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import de.peterspan.csv2db.converter.AbstractConverter;
import de.peterspan.csv2db.domain.entities.Location;

@Component
public class LocationConverter extends AbstractConverter {

	public LocationConverter() {
		super();
	};

	public LocationConverter(File inputFile) {
		super(inputFile);
	}

	public void readLine(String[] line) {
		LocationDataLine datasetLine = new LocationDataLine(line);

		Location loc = datasetLine.getLocation();
		entityManager.persist(loc);
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
				readLine(line);

			}

			entityManager.flush();
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
		}
		
		return null;
	}

}
