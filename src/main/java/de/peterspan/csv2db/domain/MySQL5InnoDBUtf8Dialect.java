package de.peterspan.csv2db.domain;

import org.hibernate.dialect.MySQL5InnoDBDialect;

public class MySQL5InnoDBUtf8Dialect extends MySQL5InnoDBDialect {

	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
