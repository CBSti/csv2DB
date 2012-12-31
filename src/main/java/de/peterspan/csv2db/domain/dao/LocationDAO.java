package de.peterspan.csv2db.domain.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
	
	/**
	 * Creates a Location using all read-only and all non-null properties.
	 */
	public Location create(Session session, double longitude, double latitude, java.lang.String name, int locationNumber) {
		Location newEntity = new Location(longitude, latitude, name, locationNumber);
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Location with the given id.
	 */
	public Location get(Session session, int id) {
		Location entity = (Location) session.get(Location.class, id);
		return entity;
	}
	
	/**
	 * Returns the Location with the given locationNumber.
	 */
	public Location getByLocationNumber(Session session, int locationNumber) {
		Criteria criteria = session.createCriteria(Location.class);
		criteria = criteria.add(Restrictions.eq(FIELD__LOCATIONNUMBER, locationNumber));
		List<?> list = criteria.list();
		if (list != null && !list.isEmpty()) {
			return (Location) list.get(0);
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Location.
	 */
	public List<Location> getAll(Session session) {
		Criteria criteria = session.createCriteria(Location.class);
		@SuppressWarnings("unchecked")
		List<Location> entities = (List<Location>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Location.
	 */
	public List<Location> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Location.class);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.like(FIELD__NAME, _searchString.trim(), MatchMode.ANYWHERE));
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Location> entities = (List<Location>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Location.
	 */
	public void delete(Session session, Location entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Location entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Location").uniqueResult()).intValue();
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
