package de.peterspan.csv2db.converter;

import java.util.HashMap;
import java.util.Map;

public class Header {

	private static Header instance;

	public static synchronized Header getInstance() {
		if (instance == null) {
			instance = new Header();
		}
		return instance;
	}

	private Header() {
		col_header = new HashMap<Integer, String>();
		initDone = false;
	}

	private Map<Integer, String> col_header;
	private boolean initDone;

	public void init(String[] header) {
		if (!initDone) {
			for(int i=0;i<header.length;i++){
				col_header.put(new Integer(i), header[i]);
			}
			initDone = true;
		}
	}

	public void reset() {
		initDone = false;
		col_header.clear();
	}

	public String getHeader(int column) throws NotYetInitializedException {
		if (!initDone) {
			throw new NotYetInitializedException();
		}
		return col_header.get(Integer.valueOf(column));
	}

	public static class NotYetInitializedException extends Exception {

	}
}
