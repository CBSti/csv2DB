package de.peterspan.csv2db.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

/**
 * This class provides all default operations that are derived from the HEDL entity model.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
		
	private EntityManager entityManager;
	
	protected LocationDAO locationDAO = new LocationDAO();
	protected DataSetDAO dataSetDAO = new DataSetDAO();
	protected MeasurementValuesDAO measurementValuesDAO = new MeasurementValuesDAO();

	public OperationProviderBase(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	
	public void merge(Location entity) {
		getEntityManager().merge(entity);
	}

	public void merge(DataSet entity) {
		getEntityManager().merge(entity);
	}

	public void merge(MeasurementValues entity) {
		getEntityManager().merge(entity);
	}

	/** 
	 * Creates an instance of type Location using all read-only and all non-null properties.
	 */
	public Location createLocation(double longitude, double latitude, java.lang.String name, int locationNumber, java.lang.String institution, java.lang.String workPackage) {
		return locationDAO.create(getEntityManager(), longitude, latitude, name, locationNumber, institution, workPackage);
	}

	/**
	 * Returns the Location with the given id.
	 */
	public Location getLocation(int id) {
		Location entity = locationDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/** Returns the Location with the given locationNumber. */
	public Location getLocationByLocationNumber(int locationNumber) {
		Location entity = locationDAO.getByLocationNumber(getEntityManager(), locationNumber);
		return entity;
	}
		
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAllLocations() {
		final List<Location> entities = locationDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> searchLocations(String _searchString, int _maxResults) {
		return locationDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes a Location.
	 */
	public void delete(Location entity) {
		locationDAO.delete(getEntityManager(), entity);
	}
	
		/**
	 * Counts the number of Location entities.
	 */
	public int countLocations() {
		return locationDAO.count(getEntityManager());
	}
	
	/** 
	 * Creates an instance of type DataSet using all read-only and all non-null properties.
	 */
	public DataSet createDataSet(java.util.Date acquisitionDate, int standingYear, int rotation, int clone, int repetition, int treeNumber, java.lang.String identNumber) {
		return dataSetDAO.create(getEntityManager(), acquisitionDate, standingYear, rotation, clone, repetition, treeNumber, identNumber);
	}

	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet getDataSet(int id) {
		DataSet entity = dataSetDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/** Returns the DataSets with the given location. */
	public List<DataSet> getDataSetsByLocation(Location location) {
		List<DataSet> entities = dataSetDAO.getByLocation(getEntityManager(), location);
		return entities;
	}
		
	/** Returns the DataSets with the given measurementValues. */
	public List<DataSet> getDataSetsByMeasurementValues(MeasurementValues measurementValues) {
		List<DataSet> entities = dataSetDAO.getByMeasurementValues(getEntityManager(), measurementValues);
		return entities;
	}
		
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		final List<DataSet> entities = dataSetDAO.getAcquisitionDateBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		final List<DataSet> entities = dataSetDAO.getAcquisitionDateAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAllDataSets() {
		final List<DataSet> entities = dataSetDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSets(String _searchString, int _maxResults) {
		return dataSetDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes a DataSet.
	 */
	public void delete(DataSet entity) {
		dataSetDAO.delete(getEntityManager(), entity);
	}
	
		/**
	 * Deletes all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		Query query = getEntityManager().createQuery(
			"DELETE FROM " + DataSet.class.getName() + " " +
			"WHERE " + DataSetDAO.FIELD__ACQUISITIONDATE + " < ?1"
		);
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		Query query = getEntityManager().createQuery(
			"DELETE FROM " + DataSet.class.getName() + " " +
			"WHERE " + DataSetDAO.FIELD__ACQUISITIONDATE + " > ?1"
		);
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of DataSet entities.
	 */
	public int countDataSets() {
		return dataSetDAO.count(getEntityManager());
	}
	
	/** 
	 * Creates an instance of type MeasurementValues using all read-only and all non-null properties.
	 */
	public MeasurementValues createMeasurementValues() {
		return measurementValuesDAO.create(getEntityManager());
	}

	/**
	 * Returns the MeasurementValues with the given id.
	 */
	public MeasurementValues getMeasurementValues(int id) {
		MeasurementValues entity = measurementValuesDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type MeasurementValues.
	 */
	public List<MeasurementValues> getAllMeasurementValuess() {
		final List<MeasurementValues> entities = measurementValuesDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type MeasurementValues.
	 */
	public List<MeasurementValues> searchMeasurementValuess(String _searchString, int _maxResults) {
		return measurementValuesDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes a MeasurementValues.
	 */
	public void delete(MeasurementValues entity) {
		measurementValuesDAO.delete(getEntityManager(), entity);
	}
	
		/**
	 * Counts the number of MeasurementValues entities.
	 */
	public int countMeasurementValuess() {
		return measurementValuesDAO.count(getEntityManager());
	}
	
}
