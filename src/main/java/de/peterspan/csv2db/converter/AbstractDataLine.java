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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractDataLine {

	private static final Log log = LogFactory.getLog(AbstractDataLine.class);
	
	public static Double string2double(String value) {
		try {
			value = value.replace(",", ".");
			return Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			log.error("Could not convert string " + value + " to double.", nfe);
			return null;
		}
	}

	public static Integer string2int(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			log.error("Could not convert string " + value + " to integer.", nfe);
			return null;
		}
	}
	
	protected List<String> dataValues;

	public AbstractDataLine(List<String> dataValues) {
		this.dataValues = dataValues;
	}
	
	public AbstractDataLine(String[] values){
		dataValues = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {
			dataValues.add(values[i]);
		}
	}

	public List<String> getDataValues() {
		return dataValues;
	}

	public void setDataValues(List<String> dataValues) {
		this.dataValues = dataValues;
	}
	

}
