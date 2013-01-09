package de.peterspan.csv2db.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "measurementvalues"
)
/*
 * This class is generated from the entity 'MeasurementValues' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class MeasurementValues {
	
	@GenericGenerator(name="MeasurementValuesIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="MeasurementValues"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="MeasurementValuesIdGenerator")
	private int id;

	@Column(name="numberofsprouds")
	private int numberOfSprouds;
	
	@Column(name="bhd_1")
	private double bhd_1;
	
	@Column(name="d_01_1")
	private double d_01_1;
	
	@Column(name="bhd_2")
	private double bhd_2;
	
	@Column(name="d_01_2")
	private double d_01_2;
	
	@Column(name="bhd_3")
	private double bhd_3;
	
	@Column(name="d_01_3")
	private double d_01_3;
	
	@Column(name="bhd_4")
	private double bhd_4;
	
	@Column(name="d_01_4")
	private double d_01_4;
	
	@Column(name="bhd_5")
	private double bhd_5;
	
	@Column(name="d_01_5")
	private double d_01_5;
	
	@Column(name="bhd_6")
	private double bhd_6;
	
	@Column(name="d_01_6")
	private double d_01_6;
	
	@Column(name="bhd_7")
	private double bhd_7;
	
	@Column(name="d_01_7")
	private double d_01_7;
	
	@Column(name="bhd_8")
	private double bhd_8;
	
	@Column(name="d_01_8")
	private double d_01_8;
	
	@Column(name="height")
	private double height;
	
	@Column(name="l_1")
	private double l_1;
	
	@Column(name="l_2")
	private double l_2;
	
	@Column(name="l_3")
	private double l_3;
	
	@Column(name="l_4")
	private double l_4;
	
	@Column(name="l_5")
	private double l_5;
	
	@Column(name="l_6")
	private double l_6;
	
	@Column(name="l_7")
	private double l_7;
	
	@Column(name="l_8")
	private double l_8;
	
	/**
	 * Default constructor. Only used by Hibernate.
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
	 * Returns the value of property 'numberOfSprouds'.
	 */
	public int getNumberOfSprouds() {
		return numberOfSprouds;
	}
	
	/**
	 * Sets the value of property 'numberOfSprouds'.
	 */
	public void setNumberOfSprouds(int newValue) {
		this.numberOfSprouds = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_1'.
	 */
	public double getBhd_1() {
		return bhd_1;
	}
	
	/**
	 * Sets the value of property 'bhd_1'.
	 */
	public void setBhd_1(double newValue) {
		this.bhd_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_1'.
	 */
	public double getD_01_1() {
		return d_01_1;
	}
	
	/**
	 * Sets the value of property 'd_01_1'.
	 */
	public void setD_01_1(double newValue) {
		this.d_01_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_2'.
	 */
	public double getBhd_2() {
		return bhd_2;
	}
	
	/**
	 * Sets the value of property 'bhd_2'.
	 */
	public void setBhd_2(double newValue) {
		this.bhd_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_2'.
	 */
	public double getD_01_2() {
		return d_01_2;
	}
	
	/**
	 * Sets the value of property 'd_01_2'.
	 */
	public void setD_01_2(double newValue) {
		this.d_01_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_3'.
	 */
	public double getBhd_3() {
		return bhd_3;
	}
	
	/**
	 * Sets the value of property 'bhd_3'.
	 */
	public void setBhd_3(double newValue) {
		this.bhd_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_3'.
	 */
	public double getD_01_3() {
		return d_01_3;
	}
	
	/**
	 * Sets the value of property 'd_01_3'.
	 */
	public void setD_01_3(double newValue) {
		this.d_01_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_4'.
	 */
	public double getBhd_4() {
		return bhd_4;
	}
	
	/**
	 * Sets the value of property 'bhd_4'.
	 */
	public void setBhd_4(double newValue) {
		this.bhd_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_4'.
	 */
	public double getD_01_4() {
		return d_01_4;
	}
	
	/**
	 * Sets the value of property 'd_01_4'.
	 */
	public void setD_01_4(double newValue) {
		this.d_01_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_5'.
	 */
	public double getBhd_5() {
		return bhd_5;
	}
	
	/**
	 * Sets the value of property 'bhd_5'.
	 */
	public void setBhd_5(double newValue) {
		this.bhd_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_5'.
	 */
	public double getD_01_5() {
		return d_01_5;
	}
	
	/**
	 * Sets the value of property 'd_01_5'.
	 */
	public void setD_01_5(double newValue) {
		this.d_01_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_6'.
	 */
	public double getBhd_6() {
		return bhd_6;
	}
	
	/**
	 * Sets the value of property 'bhd_6'.
	 */
	public void setBhd_6(double newValue) {
		this.bhd_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_6'.
	 */
	public double getD_01_6() {
		return d_01_6;
	}
	
	/**
	 * Sets the value of property 'd_01_6'.
	 */
	public void setD_01_6(double newValue) {
		this.d_01_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_7'.
	 */
	public double getBhd_7() {
		return bhd_7;
	}
	
	/**
	 * Sets the value of property 'bhd_7'.
	 */
	public void setBhd_7(double newValue) {
		this.bhd_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_7'.
	 */
	public double getD_01_7() {
		return d_01_7;
	}
	
	/**
	 * Sets the value of property 'd_01_7'.
	 */
	public void setD_01_7(double newValue) {
		this.d_01_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'bhd_8'.
	 */
	public double getBhd_8() {
		return bhd_8;
	}
	
	/**
	 * Sets the value of property 'bhd_8'.
	 */
	public void setBhd_8(double newValue) {
		this.bhd_8 = newValue;
	}
	
	/**
	 * Returns the value of property 'd_01_8'.
	 */
	public double getD_01_8() {
		return d_01_8;
	}
	
	/**
	 * Sets the value of property 'd_01_8'.
	 */
	public void setD_01_8(double newValue) {
		this.d_01_8 = newValue;
	}
	
	/**
	 * Returns the value of property 'height'.
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Sets the value of property 'height'.
	 */
	public void setHeight(double newValue) {
		this.height = newValue;
	}
	
	/**
	 * Returns the value of property 'l_1'.
	 */
	public double getL_1() {
		return l_1;
	}
	
	/**
	 * Sets the value of property 'l_1'.
	 */
	public void setL_1(double newValue) {
		this.l_1 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_2'.
	 */
	public double getL_2() {
		return l_2;
	}
	
	/**
	 * Sets the value of property 'l_2'.
	 */
	public void setL_2(double newValue) {
		this.l_2 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_3'.
	 */
	public double getL_3() {
		return l_3;
	}
	
	/**
	 * Sets the value of property 'l_3'.
	 */
	public void setL_3(double newValue) {
		this.l_3 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_4'.
	 */
	public double getL_4() {
		return l_4;
	}
	
	/**
	 * Sets the value of property 'l_4'.
	 */
	public void setL_4(double newValue) {
		this.l_4 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_5'.
	 */
	public double getL_5() {
		return l_5;
	}
	
	/**
	 * Sets the value of property 'l_5'.
	 */
	public void setL_5(double newValue) {
		this.l_5 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_6'.
	 */
	public double getL_6() {
		return l_6;
	}
	
	/**
	 * Sets the value of property 'l_6'.
	 */
	public void setL_6(double newValue) {
		this.l_6 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_7'.
	 */
	public double getL_7() {
		return l_7;
	}
	
	/**
	 * Sets the value of property 'l_7'.
	 */
	public void setL_7(double newValue) {
		this.l_7 = newValue;
	}
	
	/**
	 * Returns the value of property 'l_8'.
	 */
	public double getL_8() {
		return l_8;
	}
	
	/**
	 * Sets the value of property 'l_8'.
	 */
	public void setL_8(double newValue) {
		this.l_8 = newValue;
	}
	
}
