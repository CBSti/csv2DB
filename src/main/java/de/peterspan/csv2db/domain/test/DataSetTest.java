package de.peterspan.csv2db.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.custom.domainDAO;
import de.peterspan.csv2db.domain.dao.ICommand;
import de.peterspan.csv2db.domain.entities.DataSet;

/*
 * This test is generated for the entity 'DataSet' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class DataSetTest {

	private domainDAO dao;
	protected int dummyValueCounter;
	protected Throwable lastException;

	@org.junit.Before
	public void setUp() {
		dao = new domainDAO(this.getClass()) {
		
			@Override
			public void handleException(Throwable e, boolean retry) {
				super.handleException(e, retry);
				lastException = e;
			}
		};
		dummyValueCounter = 0;
	}

	@org.junit.After
	public void tearDown() {
		dao.tearDown();
		dao = null;
		lastException = null;
	}

	@org.junit.Test
	public void testCreate() {
		DataSet newEntity = createInstance(dao);
		assertNotNull(newEntity);
	}

	@org.junit.Test
	public void testCount() {
		assertEquals(0, dao.countDataSets());
	}

	@org.junit.Test
	public void testCreateAndCount() {
		assertEquals(0, dao.countDataSets());
		DataSet newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countDataSets());
	}

	@org.junit.Test
	public void testStringPropertyIdentNumber() {
		final DataSet entities[] = new DataSet[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[0].setIdentNumber("a");
				entities[1] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[1].setIdentNumber("ab");
				entities[2] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[2].setIdentNumber("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<DataSet> result = dao.searchDataSets("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchDataSets("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchDataSets("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}

	@org.junit.Test
	public void testStringPropertyRemark() {
		final DataSet entities[] = new DataSet[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[0].setRemark("a");
				entities[1] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[1].setRemark("ab");
				entities[2] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[2].setRemark("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<DataSet> result = dao.searchDataSets("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchDataSets("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchDataSets("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}

	@org.junit.Test
	public void testStringPropertyInputError() {
		final DataSet entities[] = new DataSet[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[0].setInputError("a");
				entities[1] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[1].setInputError("ab");
				entities[2] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				entities[2].setInputError("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<DataSet> result = dao.searchDataSets("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchDataSets("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchDataSets("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchDataSets("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}

	@org.junit.Test
	public void testDatePropertyAcquisitionDate() {
		// create test object
		assertEquals(0, dao.countDataSets());
		DataSet newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countDataSets());
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final java.util.Date newDate = new java.util.Date(oneHour);
		
		// change date property
		setAcquisitionDate(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getDataSet(id);
		assertEquals(newDate, newEntity.getAcquisitionDate());
		
		List<DataSet> before = dao.getDataSetsWithAcquisitionDateBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<DataSet> after = dao.getDataSetsWithAcquisitionDateAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());

		// change date property again (add one hour)
		setAcquisitionDate(dao, id, new java.util.Date(2 * oneHour));
		
		before = dao.getDataSetsWithAcquisitionDateBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getDataSetsWithAcquisitionDateAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());

		// change date property again (subtract one hour)
		setAcquisitionDate(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getDataSetsWithAcquisitionDateBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getDataSetsWithAcquisitionDateAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}

	private void setAcquisitionDate(domainDAO dao, final int id, final java.util.Date newValue) {
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				DataSet entity = operations.getDataSet(id);
				assertNotNull(entity);
				entity.setAcquisitionDate(newValue);
			}
		});
	}
	
	private DataSet createInstance(domainDAO dao) {
		final DataSet[] result = new DataSet[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createDataSet(new java.util.Date(), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
