package de.peterspan.csv2db.domain.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.peterspan.csv2db.domain.custom.IDBOperations;
import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

// this class is generated. any change will be overridden.
public class domainCacheBase implements IDBOperationsBase {

	protected IDBOperations delegate;
	private int nextObjectID = 0;
	
	public domainCacheBase(IDBOperations delegate) {
		super();
		this.delegate = delegate;
	}
	
	public void flush() {
		if (delegate == null) {
			return;
		}
		delegate.flush();
	}
	
	/**
	 * Creates a new Location using all read-only and all non-null properties.
	 */
	public Location createLocation(double longitude, double latitude, java.lang.String name, int locationNumber, java.lang.String institution, java.lang.String workPackage) {
		
		Location newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextObjectID;
			nextObjectID++;
			newEntity = new Location(longitude, latitude, name, locationNumber, institution, workPackage) {
				
				@Override
				public int getId() {
					return objectID;
				}
			};
		} else {
			newEntity = delegate.createLocation(longitude, latitude, name, locationNumber, institution, workPackage);
		}
		// add new entity to cache
		_getLocationCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location getLocation(int id) {
		Set<Location> cache = _getLocationCache();
		for (Location next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
		
	/**
	 * Returns the Location with the given locationNumber.
	 */
	public Location getLocationByLocationNumber(int locationNumber) {
		Set<Location> cache = _getLocationCache();
		for (Location next : cache) {
			if (locationNumber == next.getLocationNumber()) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAllLocations() {
		return new ArrayList<Location>(_getLocationCache());
	}
		
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> searchLocations(String _searchString, int _maxResults) {
		List<Location> result = new ArrayList<Location>();
		Set<Location> cache = _getLocationCache();
		for (Location next : cache) {
			boolean matches = false;
	
			String name = next.getName();
			if (name != null && name.contains(_searchString)) {
				matches = true;
			}
	
			String institution = next.getInstitution();
			if (institution != null && institution.contains(_searchString)) {
				matches = true;
			}
	
			String workPackage = next.getWorkPackage();
			if (workPackage != null && workPackage.contains(_searchString)) {
				matches = true;
			}
			
			if (matches) {
				result.add(next);
			}
			
			if (result.size() >= _maxResults) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Location.
	 */
	public void delete(Location entity) {
		_getLocationCache().remove(entity);
	}
	
	/**
	 * Counts the number of Location entities.
	 */
	public int countLocations() {
		return _getLocationCache().size();
	}
	
	/**
	 * Creates a new DataSet using all read-only and all non-null properties.
	 */
	public DataSet createDataSet(java.util.Date acquisitionDate, int standingYear, int rotation, int clone, int repetition, int treeNumber, java.lang.String identNumber) {
		
		DataSet newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextObjectID;
			nextObjectID++;
			newEntity = new DataSet(acquisitionDate, standingYear, rotation, clone, repetition, treeNumber, identNumber) {
				
				@Override
				public int getId() {
					return objectID;
				}
			};
		} else {
			newEntity = delegate.createDataSet(acquisitionDate, standingYear, rotation, clone, repetition, treeNumber, identNumber);
		}
		// add new entity to cache
		_getDataSetCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet getDataSet(int id) {
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
		
	/**
	 * Returns the DataSets with the given location.
	 */
	public List<DataSet> getDataSetsByLocation(Location location) {
		List<DataSet> result = new ArrayList<DataSet>();
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			if (location.equals(next.getLocation())) {
				result.add(next);
			}
		}
		return result;
	}
	
	/**
	 * Returns the DataSets with the given measurementValues.
	 */
	public List<DataSet> getDataSetsByMeasurementValues(MeasurementValues measurementValues) {
		List<DataSet> result = new ArrayList<DataSet>();
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			if (measurementValues.equals(next.getMeasurementValues())) {
				result.add(next);
			}
		}
		return result;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		List<DataSet> result = new ArrayList<DataSet>();
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			Date value = next.getAcquisitionDate();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(next);
			}
		}
		return result;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		List<DataSet> result = new ArrayList<DataSet>();
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			Date value = next.getAcquisitionDate();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(next);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAllDataSets() {
		return new ArrayList<DataSet>(_getDataSetCache());
	}
		
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> searchDataSets(String _searchString, int _maxResults) {
		List<DataSet> result = new ArrayList<DataSet>();
		Set<DataSet> cache = _getDataSetCache();
		for (DataSet next : cache) {
			boolean matches = false;
	
			String identNumber = next.getIdentNumber();
			if (identNumber != null && identNumber.contains(_searchString)) {
				matches = true;
			}
	
			String remark = next.getRemark();
			if (remark != null && remark.contains(_searchString)) {
				matches = true;
			}
	
			String inputError = next.getInputError();
			if (inputError != null && inputError.contains(_searchString)) {
				matches = true;
			}
			
			if (matches) {
				result.add(next);
			}
			
			if (result.size() >= _maxResults) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given DataSet.
	 */
	public void delete(DataSet entity) {
		_getDataSetCache().remove(entity);
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateBefore(java.util.Date _maxDate) {
		_getDataSetCache().removeAll(getDataSetsWithAcquisitionDateBefore(_maxDate));
	}
	
	/**
	 * Deletes all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public void deleteDataSetsWithAcquisitionDateAfter(java.util.Date _minDate) {
		_getDataSetCache().removeAll(getDataSetsWithAcquisitionDateAfter(_minDate));
	}
	
	/**
	 * Counts the number of DataSet entities.
	 */
	public int countDataSets() {
		return _getDataSetCache().size();
	}
	
	/**
	 * Creates a new MeasurementValues using all read-only and all non-null properties.
	 */
	public MeasurementValues createMeasurementValues() {
		
		MeasurementValues newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextObjectID;
			nextObjectID++;
			newEntity = new MeasurementValues() {
				
				@Override
				public int getId() {
					return objectID;
				}
			};
		} else {
			newEntity = delegate.createMeasurementValues();
		}
		// add new entity to cache
		_getMeasurementValuesCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the MeasurementValues with the given id.
	 */
	public MeasurementValues getMeasurementValues(int id) {
		Set<MeasurementValues> cache = _getMeasurementValuesCache();
		for (MeasurementValues next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
		
	/**
	 * Returns all entities of type MeasurementValues.
	 */
	public List<MeasurementValues> getAllMeasurementValuess() {
		return new ArrayList<MeasurementValues>(_getMeasurementValuesCache());
	}
		
	/**
	 * Searches for entities of type MeasurementValues.
	 */
	public List<MeasurementValues> searchMeasurementValuess(String _searchString, int _maxResults) {
		List<MeasurementValues> result = new ArrayList<MeasurementValues>();
		Set<MeasurementValues> cache = _getMeasurementValuesCache();
		for (MeasurementValues next : cache) {
			boolean matches = false;
			
			if (matches) {
				result.add(next);
			}
			
			if (result.size() >= _maxResults) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given MeasurementValues.
	 */
	public void delete(MeasurementValues entity) {
		_getMeasurementValuesCache().remove(entity);
	}
	
	/**
	 * Counts the number of MeasurementValues entities.
	 */
	public int countMeasurementValuess() {
		return _getMeasurementValuesCache().size();
	}
	
	/**
	 * Merge the properties of the given entity with the current 
	 * transaction context.
	 */
	public void merge(Location entity) {
		if (delegate == null) {
			return;
		}
		delegate.merge(entity);
	}

	private Set<Location> cachedLocation = null;

	protected Set<Location> _getLocationCache() {
		if (cachedLocation == null) {
			cachedLocation = new LinkedHashSet<Location>();
			if (delegate != null) {
				cachedLocation.addAll(delegate.getAllLocations());
			}
		}
		return cachedLocation;
	}

	/**
	 * Merge the properties of the given entity with the current 
	 * transaction context.
	 */
	public void merge(DataSet entity) {
		if (delegate == null) {
			return;
		}
		delegate.merge(entity);
	}

	private Set<DataSet> cachedDataSet = null;

	protected Set<DataSet> _getDataSetCache() {
		if (cachedDataSet == null) {
			cachedDataSet = new LinkedHashSet<DataSet>();
			if (delegate != null) {
				cachedDataSet.addAll(delegate.getAllDataSets());
			}
		}
		return cachedDataSet;
	}

	/**
	 * Merge the properties of the given entity with the current 
	 * transaction context.
	 */
	public void merge(MeasurementValues entity) {
		if (delegate == null) {
			return;
		}
		delegate.merge(entity);
	}

	private Set<MeasurementValues> cachedMeasurementValues = null;

	protected Set<MeasurementValues> _getMeasurementValuesCache() {
		if (cachedMeasurementValues == null) {
			cachedMeasurementValues = new LinkedHashSet<MeasurementValues>();
			if (delegate != null) {
				cachedMeasurementValues.addAll(delegate.getAllMeasurementValuess());
			}
		}
		return cachedMeasurementValues;
	}

}
