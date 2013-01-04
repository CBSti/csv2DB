package de.peterspan.csv2db.domain.dao;

import java.util.List;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

// this class is generated. any change will be overridden.
public interface IDBOperationsBase {
	
	/**
	 * Creates a new Location using all read-only and all non-null properties.
	 */
	public Location createLocation(double longitude, double latitude, java.lang.String name, int locationNumber, java.lang.String institution, java.lang.String workPackage);
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location getLocation(int id);
		
	/**
	 * Returns the Location with the given locationNumber.
	 */
	public Location getLocationByLocationNumber(int locationNumber);
	
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAllLocations();
		
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> searchLocations(String _searchString, int _maxResults);
	
	/**
	 * Deletes a Location.
	 */
	public void delete(Location entity);
	
	/**
	 * Counts the number of Location entities.
	 */
	public int countLocations();
	
	/**
	 * Creates a new DataSet using all read-only and all non-null properties.
	 */
	public DataSet createDataSet(java.util.Date acquisitionDate, int standingYear, int rotation, int treeType, int repetition, int treeNumber, java.lang.String identNumber);
	
	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet getDataSet(int id);
		
	/**
	 * Returns the DataSets with the given location.
	 */
	public List<DataSet> getDataSetsByLocation(Location location);
	
	/**
	 * Returns the DataSets with the given measurementValues.
	 */
	public List<DataSet> getDataSetsByMeasurementValues(MeasurementValues measurementValues);
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate);
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateAfter(java.util.Date _minDate);
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAllDataSets();
		
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSets(String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithLocation(final Location location, String _searchString, int _maxResults);
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSetWithMeasurementValues(final MeasurementValues measurementValues, String _searchString, int _maxResults);
	
	/**
	 * Deletes a DataSet.
	 */
	public void delete(DataSet entity);
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate);
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateAfter(java.util.Date _minDate);
	
	/**
	 * Counts the number of DataSet entities.
	 */
	public int countDataSets();
	
	/**
	 * Creates a new MeasurementValues using all read-only and all non-null properties.
	 */
	public MeasurementValues createMeasurementValues();
	
	/**
	 * Returns the MeasurementValues with the given id.
	 */
	public MeasurementValues getMeasurementValues(int id);
		
	/**
	 * Returns all entities of type MeasurementValues.
	 */
	public List<MeasurementValues> getAllMeasurementValuess();
		
	/**
	 * Searches for entities of type MeasurementValues.
	 */
	public List<MeasurementValues> searchMeasurementValuess(String _searchString, int _maxResults);
	
	/**
	 * Deletes a MeasurementValues.
	 */
	public void delete(MeasurementValues entity);
	
	/**
	 * Counts the number of MeasurementValues entities.
	 */
	public int countMeasurementValuess();
	
	
	public void update(Object entity);
}
