package de.peterspan.csv2db.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.peterspan.csv2db.domain.entities.DataSet;
import de.peterspan.csv2db.domain.entities.Location;
import de.peterspan.csv2db.domain.entities.MeasurementValues;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type DataSet.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class DataSetDAO {
	
	public final static String FIELD__ID = getField(DataSet.class, "id");
	public final static String FIELD__ACQUISITIONDATE = getField(DataSet.class, "acquisitionDate");
	public final static String FIELD__STANDINGYEAR = getField(DataSet.class, "standingYear");
	public final static String FIELD__ROTATION = getField(DataSet.class, "rotation");
	public final static String FIELD__CLONE = getField(DataSet.class, "clone");
	public final static String FIELD__REPETITION = getField(DataSet.class, "repetition");
	public final static String FIELD__TREENUMBER = getField(DataSet.class, "treeNumber");
	public final static String FIELD__IDENTNUMBER = getField(DataSet.class, "identNumber");
	public final static String FIELD__LOCATION = getField(DataSet.class, "location");
	public final static String FIELD__MEASUREMENTVALUES = getField(DataSet.class, "measurementValues");
	public final static String FIELD__REMARK = getField(DataSet.class, "remark");
	public final static String FIELD__INPUTERROR = getField(DataSet.class, "inputError");
	
	/**
	 * Creates a DataSet using all read-only and all non-null properties.
	 */
	public DataSet create(EntityManager em, java.util.Date acquisitionDate, int standingYear, int rotation, int clone, int repetition, int treeNumber, java.lang.String identNumber) {
		DataSet newEntity = new DataSet(acquisitionDate, standingYear, rotation, clone, repetition, treeNumber, identNumber);
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the DataSet with the given id.
	 */
	public DataSet get(EntityManager em, int id) {
		DataSet entity = (DataSet) em.find(DataSet.class, id);
		return entity;
	}
	
	/**
	 * Returns the DataSets with the given location.
	 */
	public List<DataSet> getByLocation(EntityManager em, Location location) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		Root<DataSet> root = query.from(DataSet.class);
		query.select(root);
		Expression<Boolean> expression = builder.equal(root.get(FIELD__LOCATION), location);
		query.where(expression);
		List<DataSet> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the DataSets with the given measurementValues.
	 */
	public List<DataSet> getByMeasurementValues(EntityManager em, MeasurementValues measurementValues) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		Root<DataSet> root = query.from(DataSet.class);
		query.select(root);
		Expression<Boolean> expression = builder.equal(root.get(FIELD__MEASUREMENTVALUES), measurementValues);
		query.where(expression);
		List<DataSet> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value before '_maxDate'.
	 */
	public List<DataSet> getAcquisitionDateBefore(EntityManager em, java.util.Date _maxDate) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		Root<DataSet> root = query.from(DataSet.class);
		query.select(root);
		Expression<Boolean> expression = builder.lessThan(root.<java.util.Date>get(FIELD__ACQUISITIONDATE), _maxDate);
		query.where(expression);
		List<DataSet> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all DataSets where acquisitionDate is set to a value after '_minDate'.
	 */
	public List<DataSet> getAcquisitionDateAfter(EntityManager em, java.util.Date _minDate) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		Root<DataSet> root = query.from(DataSet.class);
		query.select(root);
		Expression<Boolean> expression = builder.greaterThan(root.<java.util.Date>get(FIELD__ACQUISITIONDATE), _minDate);
		query.where(expression);
		List<DataSet> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type DataSet.
	 */
	public List<DataSet> getAll(EntityManager em) {
		CriteriaQuery<DataSet> query = buildGetAllQuery(em);
		List<DataSet> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type DataSet.
	 */
	public CriteriaQuery<DataSet> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		Root<DataSet> root = query.from(DataSet.class);
		query.select(root);
		return query;
	}
	
	/**
	 * Searches for entities of type DataSet.
	 */
	public List<DataSet> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("searchString must not be null.");
		}
		CriteriaBuilder builder = _em.getCriteriaBuilder();
		CriteriaQuery<DataSet> query = builder.createQuery(DataSet.class);
		// create disjunction of all string properties
		Root<DataSet> root = query.from(DataSet.class);
		query.where(builder.or(new Predicate[] {
			builder.like(root.<String>get(FIELD__IDENTNUMBER), builder.literal("%" + _searchString.trim() + "%")),
			builder.like(root.<String>get(FIELD__REMARK), builder.literal("%" + _searchString.trim() + "%")),
			builder.like(root.<String>get(FIELD__INPUTERROR), builder.literal("%" + _searchString.trim() + "%")),
		}));
		List<DataSet> entities = _em.createQuery(query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a DataSet.
	 */
	public void delete(EntityManager em, DataSet entity) {
		em.remove(entity);
	}
	
	/**
	 * Counts the number of DataSet entities.
	 */
	public int count(EntityManager em) {
		Object first = em.createQuery("select count(*) from DataSet").getResultList().get(0);
		if (first instanceof Long) {
			return ((Long) first).intValue();
		}
		throw new RuntimeException("Unexpected result for count query: " + first);
	}
		
	private static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}
