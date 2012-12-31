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
@Table(name = "location"
)
/*
 * This class is generated from the entity 'Location' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Location {
	
	@GenericGenerator(name="LocationIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Location"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="LocationIdGenerator")
	private int id;

	@Column(name="longitude")
	private double longitude;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="name")
	private java.lang.String name;
	
	@Column(name="locationnumber")
	private int locationNumber;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Location() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Location(double longitude, double latitude, java.lang.String name, int locationNumber) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.locationNumber = locationNumber;
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
	 * Returns the value of property 'longitude'.
	 */
	public double getLongitude() {
		return longitude;
	}
	
	/**
	 * Sets the value of property 'longitude'.
	 */
	public void setLongitude(double newValue) {
		this.longitude = newValue;
	}
	
	/**
	 * Returns the value of property 'latitude'.
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Sets the value of property 'latitude'.
	 */
	public void setLatitude(double newValue) {
		this.latitude = newValue;
	}
	
	/**
	 * Returns the value of property 'name'.
	 */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * Sets the value of property 'name'.
	 */
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
	/**
	 * Returns the value of property 'locationNumber'.
	 */
	public int getLocationNumber() {
		return locationNumber;
	}
	
	/**
	 * Sets the value of property 'locationNumber'.
	 */
	public void setLocationNumber(int newValue) {
		this.locationNumber = newValue;
	}
	
}
