package de.peterspan.csv2db.domain.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.custom.OperationProvider;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

// this class is generated. any change will be overridden.
public abstract class domainDAOBase implements IDBOperationsBase {
	
	public final static Class<?>[] ENTITY_CLASSES = new Class<?>[] {
		Location.class,
		DataSet.class,
		MeasurementValues.class,
	};

	private static EntityManagerFactory entityManagerFactory;
	
	private Class<?> contextClass;

	public domainDAOBase() {
		this(null);
	}
	
	/**
	 * Creates a new DAO that uses the given context class to load the
	 * JPA configuration file 'persistence.properties' using 
	 * Class.getResourceAsStream().
	 */
	public domainDAOBase(Class<?> contextClass) {
		this.contextClass = contextClass;
	}
	
	/**
	 * Returns the context class that was used to load the JPA configuration
	 * file.
	 */
	public Class<?> getContextClass() {
		return contextClass;
	}
	
	/**
	 * Returns the name of the service provider that is defined in the
	 * persistence.xml file.
	 */
	public String getServiceName() {
		return "Service";
	}
	
	protected Map<Object, Object> getPersistenceProperties() {
		Map<Object, Object> properties = new LinkedHashMap<Object, Object>();
		if (contextClass != null) {
			InputStream stream = contextClass.getResourceAsStream("persistence.properties");
			if (stream != null) {
				try {
					Properties loadedProperties = new Properties();
					loadedProperties.load(stream);
					properties.putAll(loadedProperties);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	protected void configure() {
		Map<Object, Object> properties = getPersistenceProperties();
		entityManagerFactory = Persistence.createEntityManagerFactory(getServiceName(), properties);
	}

	protected EntityManagerFactory getEntityManagerFactory() {
		synchronized (domainDAOBase.class) {
			if (entityManagerFactory == null) {
				configure();
			}
			return entityManagerFactory;
		}
	}
	
	/**
	 * This method can be overridden if the DAO is used in a managed
	 * environment. In this case the injected EntityManager can be
	 * returned. By default this method returns null.
	 */
	protected EntityManager getEntityManager() {
		return null;
	}
	
	/**
	 * This method is only used if the DAO is used in an unmanaged
	 * environment. In this case the a new EntityManage is created
	 * using the EntityManagerFactory.
	 */
	protected EntityManager createEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.flush() instead.
	 */
	@Deprecated
	public void flush() {
	}
	
				
	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.merge(Location entity) instead.
	 */
	@Deprecated
	public void merge(Location entity) {
	}

	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.merge(DataSet entity) instead.
	 */
	@Deprecated
	public void merge(DataSet entity) {
	}

	/**
	 * This method is deprecated. It is not meant
	 * to be used on the DAO directly. 
	 * Use OperationProvider.merge(MeasurementValues entity) instead.
	 */
	@Deprecated
	public void merge(MeasurementValues entity) {
	}

	public void executeInTransaction(ICommand command) {
		executeInTransaction(command, true);
	}
	
	protected void executeInTransaction(ICommand command, boolean retry) {
		boolean successful = false;
		
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			command.execute(new OperationProvider(entityManager));
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				command.execute(new OperationProvider(entityManager));
				tx.commit();
				successful = true;
			} catch (Throwable e) {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				executeInTransaction(command, false);
			}
		}
	}
	
	public <ResultType> ResultType executeInTransaction(IFunction<ResultType> function) {
		return executeInTransaction(function, true);
	}
	
	protected <ResultType> ResultType executeInTransaction(IFunction<ResultType> function, boolean retry) {
		boolean successful = false;
		ResultType result = null;
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			result = function.execute(new OperationProvider(entityManager));
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				result = function.execute(new OperationProvider(entityManager));
				tx.commit();
				successful = true;
			} catch (Throwable e) {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				return executeInTransaction(function, false);
			}
		}
		return result;
	}
	
	public abstract void handleException(Throwable e, boolean retry);
	
	public void tearDown() {
		synchronized (domainDAOBase.class) {
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
				entityManagerFactory = null;
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
	 * Deletes the given Location.
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
	public DataSet createDataSet(final java.util.Date acquisitionDate, final int standingYear, final int rotation, final int clone, final int repetition, final int treeNumber, final java.lang.String identNumber) {
		final DataSet[] entity = new DataSet[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createDataSet(acquisitionDate, standingYear, rotation, clone, repetition, treeNumber, identNumber);
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
	 * Deletes the given DataSet.
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
	 * Deletes the given MeasurementValues.
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
