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

	@SuppressWarnings("serial")
	public static class NotYetInitializedException extends Exception {

	}
}
