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

import java.util.ArrayList;
import java.util.List;

import de.peterspan.csv2db.domain.entities.Location;

public class LocationDataLine {
	public static final int location_number = 0;
	public static final int institution = 1;
	public static final int location_name = 2;
	public static final int work_package = 3;
	List<String> dataValues;

	public LocationDataLine(String[] values) {
		dataValues = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {
			dataValues.add(values[i]);
		}
	}

	public Location getLocation() {
		Location loc = new Location();

		loc.setLocationNumber(Integer.parseInt(dataValues.get(location_number)));
		loc.setName(dataValues.get(location_name));
		loc.setWorkPackage(dataValues.get(work_package));
		loc.setInstitution(dataValues.get(institution));
		return loc;
	}
}
