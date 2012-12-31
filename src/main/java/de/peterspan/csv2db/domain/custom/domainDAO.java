package de.peterspan.csv2db.domain.custom;

import de.peterspan.csv2db.domain.dao.domainDAOBase;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class domainDAO extends domainDAOBase {

	public domainDAO(Class<?> contextClass) {
		super(contextClass);
	}
	
	public void handleException(Exception e, boolean retry) {
		e.printStackTrace();
	}
}
