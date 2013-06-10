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

	
	public Date tryParseDate(String dateString){
		DateTime date = formatter.parseDateTime(dateString);
		return date.toDate();
	}
}
