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
