package de.peterspan.csv2db.domain.custom;

import javax.persistence.EntityManager;

import de.peterspan.csv2db.domain.dao.OperationProviderBase;

// this class is only generated once. it can be customized and all changes
// will be preserved.
public class OperationProvider extends OperationProviderBase implements IDBOperations {

	public OperationProvider(EntityManager em) {
		super(em);
	}

}
