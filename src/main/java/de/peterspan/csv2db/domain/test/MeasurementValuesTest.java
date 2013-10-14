package de.peterspan.csv2db.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.custom.domainDAO;
import de.peterspan.csv2db.domain.dao.ICommand;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

/*
 * This test is generated for the entity 'MeasurementValues' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class MeasurementValuesTest {

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
		MeasurementValues newEntity = createInstance(dao);
		assertNotNull(newEntity);
	}

	@org.junit.Test
	public void testCount() {
		assertEquals(0, dao.countMeasurementValuess());
	}

	@org.junit.Test
	public void testCreateAndCount() {
		assertEquals(0, dao.countMeasurementValuess());
		MeasurementValues newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countMeasurementValuess());
	}

	private MeasurementValues createInstance(domainDAO dao) {
		final MeasurementValues[] result = new MeasurementValues[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createMeasurementValues();
			}
		});
		return result[0];
	}
}
