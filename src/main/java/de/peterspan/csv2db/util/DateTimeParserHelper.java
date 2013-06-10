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
package de.peterspan.csv2db.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;

public class DateTimeParserHelper {

	private static DateTimeParserHelper instance;
	
	DateTimeFormatter formatter; 
	
	private DateTimeParserHelper() {
		DateTimeParser[] parsers = { 
		        DateTimeFormat.forPattern( "yyyy-MM-dd" ).getParser(),
		        DateTimeFormat.forPattern( "yyyyMMdd" ).getParser(), 
		        DateTimeFormat.forPattern( "yyyy.MM.dd" ).getParser(), 
		        DateTimeFormat.forPattern("dd.MM.yyyy").getParser(),
		        DateTimeFormat.forPattern("dd-MM-yyyy").getParser(),
		        DateTimeFormat.forPattern("ddMMyyyy").getParser()};
		formatter = new DateTimeFormatterBuilder().append(null, parsers).toFormatter();
	};
	
	public static synchronized DateTimeParserHelper getInstance() {
		if (instance == null)
			instance = new DateTimeParserHelper();
		return instance;
	}

	
	public Date tryParseDate(String dateString) throws IllegalArgumentException{
		DateTime date = formatter.parseDateTime(dateString);
		return date.toDate();
	}
}
