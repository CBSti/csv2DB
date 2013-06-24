package de.peterspan.csv2db.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class DateTimeParserHelperTest {

	@Test
	public void test(){
		DateTimeParserHelper helper = DateTimeParserHelper.getInstance();
		Date date1 = helper.tryParseDate("20130522");
		assertNotNull(date1);
		Date date2 = helper.tryParseDate("22.05.2013");
		assertNotNull(date2);
		Date date3 = helper.tryParseDate("2013.05.22");
		assertNotNull(date3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exception(){
		DateTimeParserHelper helper = DateTimeParserHelper.getInstance();
		@SuppressWarnings("unused")
		Date date1 = helper.tryParseDate("ffasf");
	}
}
