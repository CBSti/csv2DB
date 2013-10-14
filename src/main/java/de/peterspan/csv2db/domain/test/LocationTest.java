package de.peterspan.csv2db.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.custom.domainDAO;
import de.peterspan.csv2db.domain.dao.ICommand;
import de.peterspan.csv2db.domain.entities.Location;

/*
 * This test is generated for the entity 'Location' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class LocationTest {

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
		Location newEntity = createInstance(dao);
		assertNotNull(newEntity);
	}

	@org.junit.Test
	public void testCount() {
		assertEquals(0, dao.countLocations());
	}

	@org.junit.Test
	public void testCreateAndCount() {
		assertEquals(0, dao.countLocations());
		Location newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countLocations());
	}

	@org.junit.Test
	public void testUniquePropertyLocationNumber() {
		final Location entities[] = new Location[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createLocation((dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
			}
		});
		final Location entity = entities[0];
		assertNotNull("Entity must be created.", entity);
		
		assertNull("There must not be exceptions up to this point.", lastException);
		// test creation of a second object having the same (unique) value
		dao.executeInTransaction(new ICommand() {

			public void execute(IDBOperations operations) {
				Location secondEntity = operations.createLocation((dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				secondEntity.setLocationNumber(entities[0].getLocationNumber());
			}
		});
		assertNotNull("Must not be able to create second object with same value for unique property.", lastException);
		lastException = null;
		
		// Use final arrays to store result of execute()
		final int[] locationNumber1 = new int[1];
		final int[] locationNumber2 = new int[1];
		
		// Create two new values for unique property
		dao.executeInTransaction(new ICommand() {
		
			public void execute(IDBOperations operations) {
				locationNumber1[0] = (dummyValueCounter++);
				locationNumber2[0] = (dummyValueCounter++);
			}
		});
		
		// Check that objects were actually created
		assertNull(lastException);
		assertNotNull(locationNumber1[0]);
		assertNotNull(locationNumber2[0]);
		
		// Change value of unique property and test retrieval
		setLocationNumber(entity.getId(), locationNumber2[0]);
		
		assertNull("Entity must not exist.", dao.getLocationByLocationNumber(locationNumber1[0]));
		assertNotNull("Entity must exist.", dao.getLocationByLocationNumber(locationNumber2[0]));
	}

	private void setLocationNumber(final int id, final int newValue) {
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				Location entity = operations.getLocation(id);
				assertNotNull(entity);
				entity.setLocationNumber(newValue);
			}
		});
	}

	private Location createInstance(domainDAO dao) {
		final Location[] result = new Location[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createLocation((dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
