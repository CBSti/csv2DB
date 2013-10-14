package de.peterspan.csv2db.domain.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.peterspan.csv2db.domain.entities.Location;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Location.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class LocationDAO {
	
	public final static String FIELD__ID = getField(Location.class, "id");
	public final static String FIELD__LONGITUDE = getField(Location.class, "longitude");
	public final static String FIELD__LATITUDE = getField(Location.class, "latitude");
	public final static String FIELD__NAME = getField(Location.class, "name");
	public final static String FIELD__LOCATIONNUMBER = getField(Location.class, "locationNumber");
	public final static String FIELD__INSTITUTION = getField(Location.class, "institution");
	public final static String FIELD__WORKPACKAGE = getField(Location.class, "workPackage");
	
	/**
	 * Creates a Location using all read-only and all non-null properties.
	 */
	public Location create(EntityManager em, double longitude, double latitude, java.lang.String name, int locationNumber, java.lang.String institution, java.lang.String workPackage) {
		Location newEntity = new Location(longitude, latitude, name, locationNumber, institution, workPackage);
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location get(EntityManager em, int id) {
		Location entity = (Location) em.find(Location.class, id);
		return entity;
	}
	
	/**
	 * Returns the Location with the given locationNumber.
	 */
	public Location getByLocationNumber(EntityManager _em, int locationNumber) {
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Location> _query = _builder.createQuery(Location.class);
		Root<Location> _root = _query.from(Location.class);
		_query.select(_root);
		Expression<Boolean> _expression = _builder.equal(_root.get(FIELD__LOCATIONNUMBER), locationNumber);
		_query.where(_expression);
		List<Location> _entities = _em.createQuery(_query).getResultList();
		if (_entities != null && !_entities.isEmpty()) {
			return _entities.get(0);
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAll(EntityManager em) {
		CriteriaQuery<Location> query = buildGetAllQuery(em);
		List<Location> entities = em.createQuery(query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Location.
	 */
	public CriteriaQuery<Location> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Location> query = builder.createQuery(Location.class);
		Root<Location> root = query.from(Location.class);
		query.select(root);
		return query;
	}
	
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("searchString must not be null.");
		}
		CriteriaBuilder builder = _em.getCriteriaBuilder();
		CriteriaQuery<Location> query = builder.createQuery(Location.class);
		// create disjunction of all string properties
		Root<Location> root = query.from(Location.class);
		query.where(builder.or(new Predicate[] {
			builder.like(root.<String>get(FIELD__NAME), builder.literal("%" + _searchString.trim() + "%")),
			builder.like(root.<String>get(FIELD__INSTITUTION), builder.literal("%" + _searchString.trim() + "%")),
			builder.like(root.<String>get(FIELD__WORKPACKAGE), builder.literal("%" + _searchString.trim() + "%")),
		}));
		List<Location> entities = _em.createQuery(query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Location.
	 */
	public void delete(EntityManager em, Location entity) {
		em.remove(entity);
	}
	
	/**
	 * Counts the number of Location entities.
	 */
	public int count(EntityManager em) {
		Object first = em.createQuery("select count(*) from Location").getResultList().get(0);
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
