package de.peterspan.csv2db.domain.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.custom.OperationProvider;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

// this class is generated. any change will be overridden.
public abstract class domainDAOBase implements IDBOperationsBase {
	
	private static SessionFactory sessionFactory;
	
	private Class<?> contextClass;

	public domainDAOBase() {
		this(null);
	}
	
	/**
	 * Creates a new DAO that uses the given context class to load the
	 * Hibernate configuration 'hibernate.properties' using 
	 * Class.getResourceAsStream().
	 */
	public domainDAOBase(Class<?> contextClass) {
		this.contextClass = contextClass;
	}
	
	private void configure() throws HibernateException {
		Configuration configuration = getConfiguration();
		//configuration.setProperty("hibernate.show_sql", "true");
		sessionFactory = configuration.buildSessionFactory();
	}

	private Configuration getConfiguration() {
		Configuration configuration = new Configuration();
		configuration = configuration.addAnnotatedClass(Location.class);
		configuration = configuration.addAnnotatedClass(DataSet.class);
		configuration = configuration.addAnnotatedClass(MeasurementValues.class);
		if (contextClass != null) {
			Properties properties = new Properties();
			try {
				properties.load(contextClass.getResourceAsStream("hibernate.properties"));
			} catch(IOException ioe) {
				throw new RuntimeException("Can't find hibernate.properties next to context class.");
			}
			configuration.setProperties(properties);
		}
		return configuration;
	}
	
	protected SessionFactory getSessionFactory() {
		synchronized (domainDAOBase.class) {
			if (sessionFactory == null) {
				configure();
			}
			return sessionFactory;
		}
	}
	
	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.update(Object entity) instead.
	 */
	@Deprecated
	public void update(Object entity) {
	}
	
	public void createSchema() throws HibernateException {
		SchemaExport schemaExport = new SchemaExport(getConfiguration());
		schemaExport.setFormat(true);
		schemaExport.create(false, false);
	}

	public void updateSchema() {
		SchemaUpdate update = new SchemaUpdate(getConfiguration());
		update.execute(true, true);
		List<?> exceptions = update.getExceptions();
		for (Object object : exceptions) {
			System.err.println("Exception while updating schema " + object);
		}
	}
	
	public void executeInTransaction(ICommand command) {
		executeInTransaction(command, true);
	}
	
	private void executeInTransaction(ICommand command, boolean retry) {
		boolean successful = false;
		boolean closed = false;
		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			command.execute(new OperationProvider(session));
			tx.commit();
			successful = true;
		} catch (Exception e) {
			handleException(e, retry);
			if (tx != null) {
				try {
					tx.rollback();
				} catch (TransactionException te) {
					handleException(te, retry);
				}
			}
		} finally {
			try {
				session.close();
				closed = true;
			} catch (HibernateException he) {
				handleException(he, retry);
			}
		}
		
		if ((!successful || !closed) && retry) {
			// retry once
			executeInTransaction(command, false);
		}
	}
	
	public abstract void handleException(Exception e, boolean retry);
	
	public Statistics getStatistics() {
		Statistics statistics = sessionFactory.getStatistics();
		return statistics;
	}
	
	public void tearDown() {
		synchronized (domainDAOBase.class) {
			if (sessionFactory != null) {
				sessionFactory.close();
				sessionFactory = null;
			}
		}
	}

	/**
	 * Creates a new Location using all read-only and all non-null properties.
	 */
	public Location createLocation(final double longitude, final double latitude, final java.lang.String name, final int locationNumber, final java.lang.String institution, final java.lang.String workPackage) {
		final Location[] entity = new Location[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLocation(longitude, latitude, name, locationNumber, institution, workPackage);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location getLocation(final int id) {
		final Location[] entity = new Location[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLocation(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Location with the given locationNumber.
	 */
	public Location getLocationByLocationNumber(final int locationNumber) {
		final Location[] entity = new Location[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLocationByLocationNumber(locationNumber);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAllLocations() {
		final List<Location> entities = new ArrayList<Location>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllLocations());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> searchLocations(final String _searchString, final int _maxResults) {
		final List<Location> entities = new ArrayList<Location>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchLocations(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a Location.
	 */
	public void delete(final Location entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of Location entities.
	 */
	public int countLocations() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countLocations();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new DataSet using all read-only and all non-null properties.
	 */
	public DataSet createDataSet(final java.util.Date acquisitionDate, final int standingYear, final int rotation, final int treeType, final int repetition, final int treeNumber, final java.lang.String identNumber) {
		final DataSet[] entity = new DataSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createDataSet(acquisitionDate, standingYear, rotation, treeType, repetition, treeNumber, identNumber);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet getDataSet(final int id) {
		final DataSet[] entity = new DataSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getDataSet(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the DataSets with the given location.
	 */
	public List<DataSet> getDataSetsByLocation(final Location location) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDataSetsByLocation(location));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the DataSets with the given measurementValues.
	 */
	public List<DataSet> getDataSetsByMeasurementValues(final MeasurementValues measurementValues) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDataSetsByMeasurementValues(measurementValues));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateBefore(final java.util.Date _maxDate) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDataSetsWithAcquisitionDateBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateAfter(final java.util.Date _minDate) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getDataSetsWithAcquisitionDateAfter(_minDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAllDataSets() {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllDataSets());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSets(final String _searchString, final int _maxResults) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchDataSets(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithLocation(final Location location, final String _searchString, final int _maxResults) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchDataSetWithLocation(location, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithMeasurementValues(final MeasurementValues measurementValues, final String _searchString, final int _maxResults) {
		final List<DataSet> entities = new ArrayList<DataSet>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchDataSetWithMeasurementValues(measurementValues, _searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a DataSet.
	 */
	public void delete(final DataSet entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateBefore(final java.util.Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteDataSetsWithAcquisitionDateBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateAfter(final java.util.Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteDataSetsWithAcquisitionDateBefore(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of DataSet entities.
	 */
	public int countDataSets() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countDataSets();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new MeasurementValues using all read-only and all non-null properties.
	 */
	public MeasurementValues createMeasurementValues() {
		final MeasurementValues[] entity = new MeasurementValues[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createMeasurementValues();
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the MeasurementValues with the given id.
	 */
	public MeasurementValues getMeasurementValues(final int id) {
		final MeasurementValues[] entity = new MeasurementValues[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getMeasurementValues(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type MeasurementValues.
	 */
	public List<MeasurementValues> getAllMeasurementValuess() {
		final List<MeasurementValues> entities = new ArrayList<MeasurementValues>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllMeasurementValuess());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type MeasurementValues.
	 */
	public List<MeasurementValues> searchMeasurementValuess(final String _searchString, final int _maxResults) {
		final List<MeasurementValues> entities = new ArrayList<MeasurementValues>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchMeasurementValuess(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes a MeasurementValues.
	 */
	public void delete(final MeasurementValues entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Counts the number of MeasurementValues entities.
	 */
	public int countMeasurementValuess() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countMeasurementValuess();
			}
		});
		return count[0];
	}
		
}
