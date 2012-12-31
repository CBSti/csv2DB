package de.peterspan.csv2db.domain.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import de.peterspan.csv2db.domain.entities.Values;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type Values.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class ValuesDAO {
	
	public final static String FIELD__ID = getField(Values.class, "id");
	public final static String FIELD__NUMBEROFSPROUDS = getField(Values.class, "numberOfSprouds");
	public final static String FIELD__BHD_1 = getField(Values.class, "bhd_1");
	public final static String FIELD__D_01_1 = getField(Values.class, "d_01_1");
	public final static String FIELD__BHD_2 = getField(Values.class, "bhd_2");
	public final static String FIELD__D_01_2 = getField(Values.class, "d_01_2");
	public final static String FIELD__BHD_3 = getField(Values.class, "bhd_3");
	public final static String FIELD__D_01_3 = getField(Values.class, "d_01_3");
	public final static String FIELD__BHD_4 = getField(Values.class, "bhd_4");
	public final static String FIELD__D_01_4 = getField(Values.class, "d_01_4");
	public final static String FIELD__BHD_5 = getField(Values.class, "bhd_5");
	public final static String FIELD__D_01_5 = getField(Values.class, "d_01_5");
	public final static String FIELD__BHD_6 = getField(Values.class, "bhd_6");
	public final static String FIELD__D_01_6 = getField(Values.class, "d_01_6");
	public final static String FIELD__BHD_7 = getField(Values.class, "bhd_7");
	public final static String FIELD__D_01_7 = getField(Values.class, "d_01_7");
	public final static String FIELD__BHD_8 = getField(Values.class, "bhd_8");
	public final static String FIELD__D_01_8 = getField(Values.class, "d_01_8");
	public final static String FIELD__HEIGHT = getField(Values.class, "height");
	public final static String FIELD__L_1 = getField(Values.class, "l_1");
	public final static String FIELD__L_2 = getField(Values.class, "l_2");
	public final static String FIELD__L_3 = getField(Values.class, "l_3");
	public final static String FIELD__L_4 = getField(Values.class, "l_4");
	public final static String FIELD__L_5 = getField(Values.class, "l_5");
	public final static String FIELD__L_6 = getField(Values.class, "l_6");
	public final static String FIELD__L_7 = getField(Values.class, "l_7");
	public final static String FIELD__L_8 = getField(Values.class, "l_8");
	
	/**
	 * Creates a Values using all read-only and all non-null properties.
	 */
	public Values create(Session session) {
		Values newEntity = new Values();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Values with the given id.
	 */
	public Values get(Session session, int id) {
		Values entity = (Values) session.get(Values.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Values.
	 */
	public List<Values> getAll(Session session) {
		Criteria criteria = session.createCriteria(Values.class);
		@SuppressWarnings("unchecked")
		List<Values> entities = (List<Values>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type Values.
	 */
	public List<Values> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(Values.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<Values> entities = (List<Values>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a Values.
	 */
	public void delete(Session session, Values entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of Values entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from Values").uniqueResult()).intValue();
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
