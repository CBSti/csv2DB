package de.peterspan.csv2db.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "measurementvalues")
/*
 * This class is generated from the entity 'MeasurementValues' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class MeasurementValues {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="numberofshoots", nullable=true)
	private java.lang.Integer numberOfShoots;
	
	@Column(name="bhd_1", nullable=true)
	private java.lang.Double bhd_1;
	
	@Column(name="d_01_1", nullable=true)
	private java.lang.Double d_01_1;
	
	@Column(name="bhd_2", nullable=true)
	private java.lang.Double bhd_2;
	
	@Column(name="d_01_2", nullable=true)
	private java.lang.Double d_01_2;
	
	@Column(name="bhd_3", nullable=true)
	private java.lang.Double bhd_3;
	
	@Column(name="d_01_3", nullable=true)
	private java.lang.Double d_01_3;
	
	@Column(name="bhd_4", nullable=true)
	private java.lang.Double bhd_4;
	
	@Column(name="d_01_4", nullable=true)
	private java.lang.Double d_01_4;
	
	@Column(name="bhd_5", nullable=true)
	private java.lang.Double bhd_5;
	
	@Column(name="d_01_5", nullable=true)
	private java.lang.Double d_01_5;
	
	@Column(name="bhd_6", nullable=true)
	private java.lang.Double bhd_6;
	
	@Column(name="d_01_6", nullable=true)
	private java.lang.Double d_01_6;
	
	@Column(name="bhd_7", nullable=true)
	private java.lang.Double bhd_7;
	
	@Column(name="d_01_7", nullable=true)
	private java.lang.Double d_01_7;
	
	@Column(name="bhd_8", nullable=true)
	private java.lang.Double bhd_8;
	
	@Column(name="d_01_8", nullable=true)
	private java.lang.Double d_01_8;
	
	@Column(name="bhd_9", nullable=true)
	private java.lang.Double bhd_9;
	
	@Column(name="d_01_9", nullable=true)
	private java.lang.Double d_01_9;
	
	@Column(name="bhd_10", nullable=true)
	private java.lang.Double bhd_10;
	
	@Column(name="d_01_10", nullable=true)
	private java.lang.Double d_01_10;
	
	@Column(name="bhd_11", nullable=true)
	private java.lang.Double bhd_11;
	
	@Column(name="d_01_11", nullable=true)
	private java.lang.Double d_01_11;
	
	@Column(name="bhd_12", nullable=true)
	private java.lang.Double bhd_12;
	
	@Column(name="bhd_13", nullable=true)
	private java.lang.Double bhd_13;
	
	@Column(name="bhd_14", nullable=true)
	private java.lang.Double bhd_14;
	
	@Column(name="bhd_15", nullable=true)
	private java.lang.Double bhd_15;
	
	@Column(name="height", nullable=true)
	private java.lang.Double height;
	
	@Column(name="l_1", nullable=true)
	private java.lang.Double l_1;
	
	@Column(name="l_2", nullable=true)
	private java.lang.Double l_2;
	
	@Column(name="l_3", nullable=true)
	private java.lang.Double l_3;
	
	@Column(name="l_4", nullable=true)
	private java.lang.Double l_4;
	
	@Column(name="l_5", nullable=true)
	private java.lang.Double l_5;
	
	@Column(name="l_6", nullable=true)
	private java.lang.Double l_6;
	
	@Column(name="l_7", nullable=true)
	private java.lang.Double l_7;
	
	@Column(name="l_8", nullable=true)
	private java.lang.Double l_8;
	
	@Column(name="l_9", nullable=true)
	private java.lang.Double l_9;
	
	@Column(name="l_10", nullable=true)
	private java.lang.Double l_10;
	
	@Column(name="l_11", nullable=true)
	private java.lang.Double l_11;
	
	@Column(name="l_12", nullable=true)
	private java.lang.Double l_12;
	
	@Column(name="l_13", nullable=true)
	private java.lang.Double l_13;
	
	/**
	 * Default constructor. Only used by JPA.
	 */
	public MeasurementValues() {
		super();
	}

	/**
	 * Returns the automatically generated id that identifies this entity object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * The property 'id' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of property 'numberOfShoots'.
	 */
	public java.lang.Integer getNumberOfShoots() {
		return numberOfShoots;
	}
	
	/**
	 * Sets the value of property 'numberOfShoots'.
	 */
	public void setNumberOfShoots(java.lang.Integer newValue) {
		this.numberOfShoots = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_1'.
	 */
	public java.lang.Double getBhd_1() {
		return bhd_1;
	}
	
	/**
	 * Sets the value of property 'bhd_1'.
	 */
	public void setBhd_1(java.lang.Double newValue) {
		this.bhd_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_1'.
	 */
	public java.lang.Double getD_01_1() {
		return d_01_1;
	}
	
	/**
	 * Sets the value of property 'd_01_1'.
	 */
	public void setD_01_1(java.lang.Double newValue) {
		this.d_01_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_2'.
	 */
	public java.lang.Double getBhd_2() {
		return bhd_2;
	}
	
	/**
	 * Sets the value of property 'bhd_2'.
	 */
	public void setBhd_2(java.lang.Double newValue) {
		this.bhd_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_2'.
	 */
	public java.lang.Double getD_01_2() {
		return d_01_2;
	}
	
	/**
	 * Sets the value of property 'd_01_2'.
	 */
	public void setD_01_2(java.lang.Double newValue) {
		this.d_01_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_3'.
	 */
	public java.lang.Double getBhd_3() {
		return bhd_3;
	}
	
	/**
	 * Sets the value of property 'bhd_3'.
	 */
	public void setBhd_3(java.lang.Double newValue) {
		this.bhd_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_3'.
	 */
	public java.lang.Double getD_01_3() {
		return d_01_3;
	}
	
	/**
	 * Sets the value of property 'd_01_3'.
	 */
	public void setD_01_3(java.lang.Double newValue) {
		this.d_01_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_4'.
	 */
	public java.lang.Double getBhd_4() {
		return bhd_4;
	}
	
	/**
	 * Sets the value of property 'bhd_4'.
	 */
	public void setBhd_4(java.lang.Double newValue) {
		this.bhd_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_4'.
	 */
	public java.lang.Double getD_01_4() {
		return d_01_4;
	}
	
	/**
	 * Sets the value of property 'd_01_4'.
	 */
	public void setD_01_4(java.lang.Double newValue) {
		this.d_01_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_5'.
	 */
	public java.lang.Double getBhd_5() {
		return bhd_5;
	}
	
	/**
	 * Sets the value of property 'bhd_5'.
	 */
	public void setBhd_5(java.lang.Double newValue) {
		this.bhd_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_5'.
	 */
	public java.lang.Double getD_01_5() {
		return d_01_5;
	}
	
	/**
	 * Sets the value of property 'd_01_5'.
	 */
	public void setD_01_5(java.lang.Double newValue) {
		this.d_01_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_6'.
	 */
	public java.lang.Double getBhd_6() {
		return bhd_6;
	}
	
	/**
	 * Sets the value of property 'bhd_6'.
	 */
	public void setBhd_6(java.lang.Double newValue) {
		this.bhd_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_6'.
	 */
	public java.lang.Double getD_01_6() {
		return d_01_6;
	}
	
	/**
	 * Sets the value of property 'd_01_6'.
	 */
	public void setD_01_6(java.lang.Double newValue) {
		this.d_01_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_7'.
	 */
	public java.lang.Double getBhd_7() {
		return bhd_7;
	}
	
	/**
	 * Sets the value of property 'bhd_7'.
	 */
	public void setBhd_7(java.lang.Double newValue) {
		this.bhd_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_7'.
	 */
	public java.lang.Double getD_01_7() {
		return d_01_7;
	}
	
	/**
	 * Sets the value of property 'd_01_7'.
	 */
	public void setD_01_7(java.lang.Double newValue) {
		this.d_01_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_8'.
	 */
	public java.lang.Double getBhd_8() {
		return bhd_8;
	}
	
	/**
	 * Sets the value of property 'bhd_8'.
	 */
	public void setBhd_8(java.lang.Double newValue) {
		this.bhd_8 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_8'.
	 */
	public java.lang.Double getD_01_8() {
		return d_01_8;
	}
	
	/**
	 * Sets the value of property 'd_01_8'.
	 */
	public void setD_01_8(java.lang.Double newValue) {
		this.d_01_8 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_9'.
	 */
	public java.lang.Double getBhd_9() {
		return bhd_9;
	}
	
	/**
	 * Sets the value of property 'bhd_9'.
	 */
	public void setBhd_9(java.lang.Double newValue) {
		this.bhd_9 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_9'.
	 */
	public java.lang.Double getD_01_9() {
		return d_01_9;
	}
	
	/**
	 * Sets the value of property 'd_01_9'.
	 */
	public void setD_01_9(java.lang.Double newValue) {
		this.d_01_9 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_10'.
	 */
	public java.lang.Double getBhd_10() {
		return bhd_10;
	}
	
	/**
	 * Sets the value of property 'bhd_10'.
	 */
	public void setBhd_10(java.lang.Double newValue) {
		this.bhd_10 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_10'.
	 */
	public java.lang.Double getD_01_10() {
		return d_01_10;
	}
	
	/**
	 * Sets the value of property 'd_01_10'.
	 */
	public void setD_01_10(java.lang.Double newValue) {
		this.d_01_10 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_11'.
	 */
	public java.lang.Double getBhd_11() {
		return bhd_11;
	}
	
	/**
	 * Sets the value of property 'bhd_11'.
	 */
	public void setBhd_11(java.lang.Double newValue) {
		this.bhd_11 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_11'.
	 */
	public java.lang.Double getD_01_11() {
		return d_01_11;
	}
	
	/**
	 * Sets the value of property 'd_01_11'.
	 */
	public void setD_01_11(java.lang.Double newValue) {
		this.d_01_11 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_12'.
	 */
	public java.lang.Double getBhd_12() {
		return bhd_12;
	}
	
	/**
	 * Sets the value of property 'bhd_12'.
	 */
	public void setBhd_12(java.lang.Double newValue) {
		this.bhd_12 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_13'.
	 */
	public java.lang.Double getBhd_13() {
		return bhd_13;
	}
	
	/**
	 * Sets the value of property 'bhd_13'.
	 */
	public void setBhd_13(java.lang.Double newValue) {
		this.bhd_13 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_14'.
	 */
	public java.lang.Double getBhd_14() {
		return bhd_14;
	}
	
	/**
	 * Sets the value of property 'bhd_14'.
	 */
	public void setBhd_14(java.lang.Double newValue) {
		this.bhd_14 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_15'.
	 */
	public java.lang.Double getBhd_15() {
		return bhd_15;
	}
	
	/**
	 * Sets the value of property 'bhd_15'.
	 */
	public void setBhd_15(java.lang.Double newValue) {
		this.bhd_15 = newValue;
	}
	
	/**
	 * Returns the value of property 'height'.
	 */
	public java.lang.Double getHeight() {
		return height;
	}
	
	/**
	 * Sets the value of property 'height'.
	 */
	public void setHeight(java.lang.Double newValue) {
		this.height = newValue;
	}
	
	/**
	 * Returns the value of property 'l_1'.
	 */
	public java.lang.Double getL_1() {
		return l_1;
	}
	
	/**
	 * Sets the value of property 'l_1'.
	 */
	public void setL_1(java.lang.Double newValue) {
		this.l_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_2'.
	 */
	public java.lang.Double getL_2() {
		return l_2;
	}
	
	/**
	 * Sets the value of property 'l_2'.
	 */
	public void setL_2(java.lang.Double newValue) {
		this.l_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_3'.
	 */
	public java.lang.Double getL_3() {
		return l_3;
	}
	
	/**
	 * Sets the value of property 'l_3'.
	 */
	public void setL_3(java.lang.Double newValue) {
		this.l_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_4'.
	 */
	public java.lang.Double getL_4() {
		return l_4;
	}
	
	/**
	 * Sets the value of property 'l_4'.
	 */
	public void setL_4(java.lang.Double newValue) {
		this.l_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_5'.
	 */
	public java.lang.Double getL_5() {
		return l_5;
	}
	
	/**
	 * Sets the value of property 'l_5'.
	 */
	public void setL_5(java.lang.Double newValue) {
		this.l_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_6'.
	 */
	public java.lang.Double getL_6() {
		return l_6;
	}
	
	/**
	 * Sets the value of property 'l_6'.
	 */
	public void setL_6(java.lang.Double newValue) {
		this.l_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_7'.
	 */
	public java.lang.Double getL_7() {
		return l_7;
	}
	
	/**
	 * Sets the value of property 'l_7'.
	 */
	public void setL_7(java.lang.Double newValue) {
		this.l_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_8'.
	 */
	public java.lang.Double getL_8() {
		return l_8;
	}
	
	/**
	 * Sets the value of property 'l_8'.
	 */
	public void setL_8(java.lang.Double newValue) {
		this.l_8 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_9'.
	 */
	public java.lang.Double getL_9() {
		return l_9;
	}
	
	/**
	 * Sets the value of property 'l_9'.
	 */
	public void setL_9(java.lang.Double newValue) {
		this.l_9 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_10'.
	 */
	public java.lang.Double getL_10() {
		return l_10;
	}
	
	/**
	 * Sets the value of property 'l_10'.
	 */
	public void setL_10(java.lang.Double newValue) {
		this.l_10 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_11'.
	 */
	public java.lang.Double getL_11() {
		return l_11;
	}
	
	/**
	 * Sets the value of property 'l_11'.
	 */
	public void setL_11(java.lang.Double newValue) {
		this.l_11 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_12'.
	 */
	public java.lang.Double getL_12() {
		return l_12;
	}
	
	/**
	 * Sets the value of property 'l_12'.
	 */
	public void setL_12(java.lang.Double newValue) {
		this.l_12 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_13'.
	 */
	public java.lang.Double getL_13() {
		return l_13;
	}
	
	/**
	 * Sets the value of property 'l_13'.
	 */
	public void setL_13(java.lang.Double newValue) {
		this.l_13 = newValue;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getId();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MeasurementValues other = (MeasurementValues) obj;
		if (getId() != other.getId()) {
			return false;
		}
		return true;
	}
}
