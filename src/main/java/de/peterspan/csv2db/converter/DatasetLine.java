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

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.peterspan.csv2db.converter.Header.NotYetInitializedException;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;
import de.peterspan.csv2db.util.DateTimeParserHelper;

public class DatasetLine extends AbstractDataLine {

	private static final Log log = LogFactory.getLog(DatasetLine.class);
	
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
	public static final int clone = 3;

	/**
	 * Wiederholung
	 */
	public static final int repetition = 4;

	/**
	 * Anzahl Höhentriebe
	 */
	public static final int number_of_shoots = 5;

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

	public static final int bhd_9 = 22;
	public static final int d_01_9 = 23;

	public static final int bhd_10 = 24;
	public static final int d_01_10 = 25;

	public static final int bhd_11 = 26;
	public static final int d_01_11 = 27;

	public static final int bhd_12 = 28;
	public static final int bhd_13 = 29;
	public static final int bhd_14 = 30;
	public static final int bhd_15 = 31;

	public static final int height = 32;

	public static final int l_1 = 33;
	public static final int l_2 = 34;
	public static final int l_3 = 35;
	public static final int l_4 = 36;
	public static final int l_5 = 37;
	public static final int l_6 = 38;
	public static final int l_7 = 39;
	public static final int l_8 = 40;
	public static final int l_9 = 41;
	public static final int l_10 = 42;
	public static final int l_11 = 43;
	public static final int l_12 = 44;
	public static final int l_13 = 45;

	public static final int remark = 46;
	public static final int location_name = 47;
	public static final int measurement_date = 48;

	public static final int treeNumber = 49;

	// 17.11.2010
	@Deprecated
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

	DateTimeParserHelper dateTimeParserHelper;

	/**
	 * ; seperated String of columns that resulted in null value fpr non empty
	 * content
	 */
	private String inputError;

	public DatasetLine(String[] values) {
		super(values);
		dateTimeParserHelper = DateTimeParserHelper.getInstance();
		inputError = "";
	}

	public String getInputErrors() {
		return inputError;
	}

	public MeasurementValues getValues() {
		MeasurementValues values = new MeasurementValues();

		Double value = DatasetLine.string2double(dataValues.get(bhd_1));

		if (wasError(value, bhd_1)) {
			addError(bhd_1);
		}

		values.setBhd_1(value);

		value = DatasetLine.string2double(dataValues.get(bhd_2));

		if (wasError(value, bhd_2)) {
			addError(bhd_2);
		}

		values.setBhd_2(value);

		value = DatasetLine.string2double(dataValues.get(bhd_3));

		if (wasError(value, bhd_3)) {
			addError(bhd_3);
		}

		values.setBhd_3(value);

		value = DatasetLine.string2double(dataValues.get(bhd_4));

		if (wasError(value, bhd_4)) {
			addError(bhd_4);
		}

		values.setBhd_4(value);

		value = DatasetLine.string2double(dataValues.get(bhd_5));

		if (wasError(value, bhd_5)) {
			addError(bhd_5);
		}

		values.setBhd_5(value);

		value = DatasetLine.string2double(dataValues.get(bhd_6));

		if (wasError(value, bhd_6)) {
			addError(bhd_6);
		}

		values.setBhd_6(value);

		value = DatasetLine.string2double(dataValues.get(bhd_7));

		if (wasError(value, bhd_7)) {
			addError(bhd_7);
		}

		values.setBhd_7(value);

		value = DatasetLine.string2double(dataValues.get(bhd_8));

		if (wasError(value, bhd_8)) {
			addError(bhd_8);
		}

		values.setBhd_8(value);

		value = DatasetLine.string2double(dataValues.get(bhd_9));

		if (wasError(value, bhd_9)) {
			addError(bhd_9);
		}

		values.setBhd_9(value);

		value = DatasetLine.string2double(dataValues.get(bhd_10));

		if (wasError(value, bhd_10)) {
			addError(bhd_10);
		}

		values.setBhd_10(value);

		value = DatasetLine.string2double(dataValues.get(bhd_11));

		if (wasError(value, bhd_11)) {
			addError(bhd_11);
		}

		values.setBhd_11(value);

		value = DatasetLine.string2double(dataValues.get(bhd_12));

		if (wasError(value, bhd_12)) {
			addError(bhd_12);
		}

		values.setBhd_12(value);

		value = DatasetLine.string2double(dataValues.get(bhd_13));

		if (wasError(value, bhd_13)) {
			addError(bhd_13);
		}

		values.setBhd_13(value);

		value = DatasetLine.string2double(dataValues.get(bhd_14));

		if (wasError(value, bhd_14)) {
			addError(bhd_14);
		}

		values.setBhd_14(value);

		value = DatasetLine.string2double(dataValues.get(bhd_15));

		if (wasError(value, bhd_15)) {
			addError(bhd_15);
		}

		values.setBhd_15(value);

		value = DatasetLine.string2double(dataValues.get(d_01_1));

		if (wasError(value, d_01_1)) {
			addError(d_01_1);
		}

		values.setD_01_1(value);

		value = DatasetLine.string2double(dataValues.get(d_01_2));

		if (wasError(value, d_01_2)) {
			addError(d_01_2);
		}

		values.setD_01_2(value);

		value = DatasetLine.string2double(dataValues.get(d_01_3));

		if (wasError(value, d_01_3)) {
			addError(d_01_3);
		}

		values.setD_01_3(value);

		value = DatasetLine.string2double(dataValues.get(d_01_4));

		if (wasError(value, d_01_4)) {
			addError(d_01_4);
		}

		values.setD_01_4(value);

		value = DatasetLine.string2double(dataValues.get(d_01_5));

		if (wasError(value, d_01_5)) {
			addError(d_01_5);
		}

		values.setD_01_5(value);

		value = DatasetLine.string2double(dataValues.get(d_01_6));

		if (wasError(value, d_01_6)) {
			addError(d_01_6);
		}

		values.setD_01_6(value);

		value = DatasetLine.string2double(dataValues.get(d_01_7));

		if (wasError(value, d_01_7)) {
			addError(d_01_7);
		}

		values.setD_01_7(value);

		value = DatasetLine.string2double(dataValues.get(d_01_8));

		if (wasError(value, d_01_8)) {
			addError(d_01_8);
		}

		values.setD_01_8(value);

		value = DatasetLine.string2double(dataValues.get(d_01_9));

		if (wasError(value, d_01_9)) {
			addError(d_01_9);
		}

		values.setD_01_9(value);

		value = DatasetLine.string2double(dataValues.get(d_01_10));

		if (wasError(value, d_01_10)) {
			addError(d_01_10);
		}

		values.setD_01_10(value);

		value = DatasetLine.string2double(dataValues.get(d_01_11));

		if (wasError(value, d_01_11)) {
			addError(d_01_11);
		}

		values.setD_01_11(value);

		value = DatasetLine.string2double(dataValues.get(l_1));

		if (wasError(value, l_1)) {
			addError(l_1);
		}

		values.setL_1(value);

		value = DatasetLine.string2double(dataValues.get(l_2));

		if (wasError(value, l_2)) {
			addError(l_2);
		}

		values.setL_2(value);

		value = DatasetLine.string2double(dataValues.get(l_3));

		if (wasError(value, l_3)) {
			addError(l_3);
		}

		values.setL_3(value);

		value = DatasetLine.string2double(dataValues.get(l_4));

		if (wasError(value, l_4)) {
			addError(l_4);
		}

		values.setL_4(value);

		value = DatasetLine.string2double(dataValues.get(l_5));

		if (wasError(value, l_5)) {
			addError(l_5);
		}

		values.setL_5(value);

		value = DatasetLine.string2double(dataValues.get(l_6));

		if (wasError(value, l_6)) {
			addError(l_6);
		}

		values.setL_6(value);

		value = DatasetLine.string2double(dataValues.get(l_7));

		if (wasError(value, l_7)) {
			addError(l_7);
		}

		values.setL_7(value);

		value = DatasetLine.string2double(dataValues.get(l_8));

		if (wasError(value, l_8)) {
			addError(l_8);
		}

		values.setL_8(value);

		value = DatasetLine.string2double(dataValues.get(l_9));

		if (wasError(value, l_9)) {
			addError(l_9);
		}

		values.setL_9(value);

		value = DatasetLine.string2double(dataValues.get(l_10));

		if (wasError(value, l_10)) {
			addError(l_10);
		}

		values.setL_10(value);

		value = DatasetLine.string2double(dataValues.get(l_11));

		if (wasError(value, l_11)) {
			addError(l_11);
		}

		values.setL_11(value);

		value = DatasetLine.string2double(dataValues.get(l_12));

		if (wasError(value, l_12)) {
			addError(l_12);
		}

		values.setL_12(value);

		value = DatasetLine.string2double(dataValues.get(l_13));

		if (wasError(value, l_13)) {
			addError(l_13);
		}

		values.setL_13(value);

		value = DatasetLine.string2double(dataValues.get(height));

		if (wasError(value, height)) {
			addError(height);
		}

		values.setHeight(value);

		Integer numberOfShoots = DatasetLine.string2int(dataValues
				.get(number_of_shoots));

		if (wasError(numberOfShoots, number_of_shoots)) {
			addError(number_of_shoots);
		}

		values.setNumberOfShoots(numberOfShoots);

		return values;
	}

	public Location getLocation() {
		Location loc = new Location();

		loc.setLocationNumber(Integer.parseInt(dataValues.get(location_number)));
		loc.setName(dataValues.get(location_name));

		return loc;
	}

	/**
	 * Checks if this dataset line is a valid line.
	 * 
	 * In particular a dataset line is invalid iff shoots is empty and remark is
	 * empty.
	 * 
	 * @return true if the dataset is valid
	 */
	public boolean isValid() {
		String remarkValue = dataValues.get(remark);
		String numberOfShootsRaw = dataValues.get(number_of_shoots);
		Integer numberOfShoots = DatasetLine.string2int(numberOfShootsRaw);

		if ((remarkValue == null || "".equals(remarkValue.trim()))
				&& numberOfShoots == null) {
			// if remark is null or empty and if numberOfShoots is empty this
			// dataset is more or less useless, so don't use it!
			// Only if the raw content is already empty/null this dataset is
			// invalid
			if (numberOfShootsRaw == null || "".equals(numberOfShootsRaw)) {
				return false;
			}

		}

		return true;
	}

	private void addError(int errorCol) {
		try {
			String errorColName = Header.getInstance().getHeader(errorCol);
			inputError = inputError + errorColName + "; ";
		} catch (NotYetInitializedException nyie) {

		}
	}

	private boolean wasError(Object result, int column) {
		if (result == null) {
			String rawValue = dataValues.get(column);
			if (rawValue != null && !"".equals(rawValue)) {
				return true;
			}
		}
		return false;
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
			date = dateTimeParserHelper.tryParseDate(dataValues
					.get(measurement_date));
			dataset.setAcquisitionDate(date);
		} catch (IllegalArgumentException e) {
			log.error("The given date " + dataValues.get(measurement_date) + " is invalid.", e);
		}

		dataset.setRemark(dataValues.get(remark));
		dataset.setRepetition(Integer.parseInt(dataValues.get(repetition)));
		dataset.setRotation(Integer.parseInt(dataValues.get(rotation)));
		dataset.setStandingYear(Integer.parseInt(dataValues.get(standing_year)));
		dataset.setClone(Integer.parseInt(dataValues.get(clone)));
		dataset.setTreeNumber(Integer.parseInt(dataValues.get(treeNumber)));

		StringBuilder sb = new StringBuilder();
		sb.append(dataset.getClone());
		sb.append(".");
		sb.append(dataset.getRepetition());
		sb.append(" - ");
		sb.append(dataset.getTreeNumber());

		dataset.setIdentNumber(sb.toString());

		return dataset;
	}
}
