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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jidesoft.spinner.DateSpinner;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

public class DatasetLine extends AbstractDataLine{

	/**
	 * Standort Nr
	 */
	public static final int location_number = 0;
	/**
	 * Standjahr
	 */
	public static final int standing_year = 1;

	/**
	 * Rotation
	 */
	public static final int rotation = 2;

	/**
	 * Baumart
	 */
	public static final int tree_type = 3;

	/**
	 * Wiederholung
	 */
	public static final int repetition = 4;

	/**
	 * Anzahl Höhentriebe
	 */
	public static final int number_of_sprouds = 5;

	public static final int bhd_1 = 6;
	public static final int d_01_1 = 7;

	public static final int bhd_2 = 8;
	public static final int d_01_2 = 9;

	public static final int bhd_3 = 10;
	public static final int d_01_3 = 11;

	public static final int bhd_4 = 12;
	public static final int d_01_4 = 13;

	public static final int bhd_5 = 14;
	public static final int d_01_5 = 15;

	public static final int bhd_6 = 16;
	public static final int d_01_6 = 17;

	public static final int bhd_7 = 18;
	public static final int d_01_7 = 19;

	public static final int bhd_8 = 20;
	public static final int d_01_8 = 21;

	public static final int height = 22;

	public static final int l_1 = 23;
	public static final int l_2 = 24;
	public static final int l_3 = 25;
	public static final int l_4 = 26;
	public static final int l_5 = 27;
	public static final int l_6 = 28;
	public static final int l_7 = 29;
	public static final int l_8 = 30;

	public static final int remark = 31;
	public static final int location_name = 32;
	public static final int measurement_date = 33;
	
	public static final int treeNumber = 34;

	// 17.11.2010
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


	public DatasetLine(String[] values) {
		super(values);
	}

	public MeasurementValues getValues() {
		MeasurementValues values = new MeasurementValues();

		Double value = DatasetLine.string2double(dataValues.get(bhd_1));

		values.setBhd_1(value);

		value = DatasetLine.string2double(dataValues.get(bhd_2));

		values.setBhd_2(value);

		value = DatasetLine.string2double(dataValues.get(bhd_3));

		values.setBhd_3(value);

		value = DatasetLine.string2double(dataValues.get(bhd_4));

		values.setBhd_4(value);

		value = DatasetLine.string2double(dataValues.get(bhd_5));

		values.setBhd_5(value);

		value = DatasetLine.string2double(dataValues.get(bhd_6));

		values.setBhd_6(value);

		value = DatasetLine.string2double(dataValues.get(bhd_7));

		values.setBhd_7(value);

		value = DatasetLine.string2double(dataValues.get(bhd_8));

		values.setBhd_8(value);

		value = DatasetLine.string2double(dataValues.get(d_01_1));

		values.setD_01_1(value);

		value = DatasetLine.string2double(dataValues.get(d_01_2));

		values.setD_01_2(value);

		value = DatasetLine.string2double(dataValues.get(d_01_3));

		values.setD_01_3(value);

		value = DatasetLine.string2double(dataValues.get(d_01_4));

		values.setD_01_4(value);

		value = DatasetLine.string2double(dataValues.get(d_01_5));

		values.setD_01_5(value);

		value = DatasetLine.string2double(dataValues.get(d_01_6));

		values.setD_01_6(value);

		value = DatasetLine.string2double(dataValues.get(d_01_7));

		values.setD_01_7(value);

		value = DatasetLine.string2double(dataValues.get(d_01_1));

		values.setD_01_8(value);

		value = DatasetLine.string2double(dataValues.get(l_1));

		values.setL_1(value);

		value = DatasetLine.string2double(dataValues.get(l_2));

		values.setL_2(value);

		value = DatasetLine.string2double(dataValues.get(l_3));

		values.setL_3(value);

		value = DatasetLine.string2double(dataValues.get(l_4));

		values.setL_4(value);

		value = DatasetLine.string2double(dataValues.get(l_5));

		values.setL_5(value);

		value = DatasetLine.string2double(dataValues.get(l_6));

		values.setL_6(value);

		value = DatasetLine.string2double(dataValues.get(l_7));

		values.setL_7(value);

		value = DatasetLine.string2double(dataValues.get(l_8));

		values.setL_8(value);

		value = DatasetLine.string2double(dataValues.get(height));
		System.out.print("Height "+value);
		values.setHeight(value);

		Integer numberOfSprouds = DatasetLine.string2int(dataValues
				.get(number_of_sprouds));

		values.setNumberOfSprouds(numberOfSprouds);

		return values;
	}

	public Location getLocation() {
		Location loc = new Location();

		loc.setLocationNumber(Integer.parseInt(dataValues.get(location_number)));
		loc.setName(dataValues.get(location_name));

		return loc;
	}

	/**
	 * Creates a plain Dataset object.
	 * 
	 * Plain means without any possible foreign key relations, so without values
	 * and location
	 * 
	 * @return
	 */
	public DataSet getDataset() {
		DataSet dataset = new DataSet();

		Date date = null;
		try {
			date = dateFormat.parse(dataValues.get(measurement_date));
			dataset.setAcquisitionDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dataset.setRemark(dataValues.get(remark));
		dataset.setRepetition(Integer.parseInt(dataValues.get(repetition)));
		dataset.setRotation(Integer.parseInt(dataValues.get(rotation)));
		dataset.setStandingYear(Integer.parseInt(dataValues.get(standing_year)));
		dataset.setTreeType(Integer.parseInt(dataValues.get(tree_type)));
		dataset.setTreeNumber(Integer.parseInt(dataValues.get(treeNumber)));
		
		StringBuilder sb = new StringBuilder();
		sb.append(dataset.getTreeType());
		sb.append(".");
		sb.append(dataset.getRepetition());
		sb.append(" - ");
		sb.append(dataset.getTreeNumber());
		
		dataset.setIdentNumber(sb.toString());

		return dataset;
	}
}
