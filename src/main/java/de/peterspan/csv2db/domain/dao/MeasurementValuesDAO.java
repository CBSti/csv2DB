package de.peterspan.csv2db.domain.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import de.peterspan.csv2db.domain.entities.MeasurementValues;

/**
 * This class provides all default operations that are derived from the HEDL entity model
 * for type MeasurementValues.
 *
 * Note: This class is generated. Any change will be overridden.
 */
public class MeasurementValuesDAO {
	
	public final static String FIELD__ID = getField(MeasurementValues.class, "id");
	public final static String FIELD__NUMBEROFSHOOTS = getField(MeasurementValues.class, "numberOfShoots");
	public final static String FIELD__BHD_1 = getField(MeasurementValues.class, "bhd_1");
	public final static String FIELD__D_01_1 = getField(MeasurementValues.class, "d_01_1");
	public final static String FIELD__BHD_2 = getField(MeasurementValues.class, "bhd_2");
	public final static String FIELD__D_01_2 = getField(MeasurementValues.class, "d_01_2");
	public final static String FIELD__BHD_3 = getField(MeasurementValues.class, "bhd_3");
	public final static String FIELD__D_01_3 = getField(MeasurementValues.class, "d_01_3");
	public final static String FIELD__BHD_4 = getField(MeasurementValues.class, "bhd_4");
	public final static String FIELD__D_01_4 = getField(MeasurementValues.class, "d_01_4");
	public final static String FIELD__BHD_5 = getField(MeasurementValues.class, "bhd_5");
	public final static String FIELD__D_01_5 = getField(MeasurementValues.class, "d_01_5");
	public final static String FIELD__BHD_6 = getField(MeasurementValues.class, "bhd_6");
	public final static String FIELD__D_01_6 = getField(MeasurementValues.class, "d_01_6");
	public final static String FIELD__BHD_7 = getField(MeasurementValues.class, "bhd_7");
	public final static String FIELD__D_01_7 = getField(MeasurementValues.class, "d_01_7");
	public final static String FIELD__BHD_8 = getField(MeasurementValues.class, "bhd_8");
	public final static String FIELD__D_01_8 = getField(MeasurementValues.class, "d_01_8");
	public final static String FIELD__BHD_9 = getField(MeasurementValues.class, "bhd_9");
	public final static String FIELD__D_01_9 = getField(MeasurementValues.class, "d_01_9");
	public final static String FIELD__BHD_10 = getField(MeasurementValues.class, "bhd_10");
	public final static String FIELD__D_01_10 = getField(MeasurementValues.class, "d_01_10");
	public final static String FIELD__BHD_11 = getField(MeasurementValues.class, "bhd_11");
	public final static String FIELD__D_01_11 = getField(MeasurementValues.class, "d_01_11");
	public final static String FIELD__BHD_12 = getField(MeasurementValues.class, "bhd_12");
	public final static String FIELD__BHD_13 = getField(MeasurementValues.class, "bhd_13");
	public final static String FIELD__BHD_14 = getField(MeasurementValues.class, "bhd_14");
	public final static String FIELD__BHD_15 = getField(MeasurementValues.class, "bhd_15");
	public final static String FIELD__HEIGHT = getField(MeasurementValues.class, "height");
	public final static String FIELD__L_1 = getField(MeasurementValues.class, "l_1");
	public final static String FIELD__L_2 = getField(MeasurementValues.class, "l_2");
	public final static String FIELD__L_3 = getField(MeasurementValues.class, "l_3");
	public final static String FIELD__L_4 = getField(MeasurementValues.class, "l_4");
	public final static String FIELD__L_5 = getField(MeasurementValues.class, "l_5");
	public final static String FIELD__L_6 = getField(MeasurementValues.class, "l_6");
	public final static String FIELD__L_7 = getField(MeasurementValues.class, "l_7");
	public final static String FIELD__L_8 = getField(MeasurementValues.class, "l_8");
	public final static String FIELD__L_9 = getField(MeasurementValues.class, "l_9");
	public final static String FIELD__L_10 = getField(MeasurementValues.class, "l_10");
	public final static String FIELD__L_11 = getField(MeasurementValues.class, "l_11");
	public final static String FIELD__L_12 = getField(MeasurementValues.class, "l_12");
	public final static String FIELD__L_13 = getField(MeasurementValues.class, "l_13");
	
	/**
	 * Creates a MeasurementValues using all read-only and all non-null properties.
	 */
	public MeasurementValues create(Session session) {
		MeasurementValues newEntity = new MeasurementValues();
		session.save(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the MeasurementValues with the given id.
	 */
	public MeasurementValues get(Session session, int id) {
		MeasurementValues entity = (MeasurementValues) session.get(MeasurementValues.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type MeasurementValues.
	 */
	public List<MeasurementValues> getAll(Session session) {
		Criteria criteria = session.createCriteria(MeasurementValues.class);
		@SuppressWarnings("unchecked")
		List<MeasurementValues> entities = (List<MeasurementValues>) criteria.list();
		return entities;
	}
	
	/**
	 * Searches for entities of type MeasurementValues.
	 */
	public List<MeasurementValues> search(Session _session, String _searchString, int _maxResults) {
		Criteria criteria = _session.createCriteria(MeasurementValues.class);
		Disjunction disjunction = Restrictions.disjunction();
		criteria = criteria.add(disjunction);
		criteria = criteria.setMaxResults(_maxResults);
		@SuppressWarnings("unchecked")
		List<MeasurementValues> entities = (List<MeasurementValues>) criteria.list();
		return entities;
	}
	
	/**
	 * Deletes a MeasurementValues.
	 */
	public void delete(Session session, MeasurementValues entity) {
		session.delete(entity);
	}
	
	/**
	 * Counts the number of MeasurementValues entities.
	 */
	public int count(Session session) {
		return ((Long) session.createQuery("select count(*) from MeasurementValues").uniqueResult()).intValue();
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
