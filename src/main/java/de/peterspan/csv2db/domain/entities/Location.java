package de.peterspan.csv2db.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
/*
 * This class is generated from the entity 'Location' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Location {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="longitude")
	private double longitude;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="name")
	private java.lang.String name;
	
	@Column(name="locationnumber", unique=true)
	private int locationNumber;
	
	@Column(name="institution")
	private java.lang.String institution;
	
	@Column(name="workpackage")
	private java.lang.String workPackage;
	
	/**
	 * Default constructor. Only used by JPA.
	 */
	public Location() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public Location(double longitude, double latitude, java.lang.String name, int locationNumber, java.lang.String institution, java.lang.String workPackage) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.locationNumber = locationNumber;
		this.institution = institution;
		this.workPackage = workPackage;
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
	
	/**
	 * Returns the value of property 'institution'.
	 */
	public java.lang.String getInstitution() {
		return institution;
	}
	
	/**
	 * Sets the value of property 'institution'.
	 */
	public void setInstitution(java.lang.String newValue) {
		this.institution = newValue;
	}
	
	/**
	 * Returns the value of property 'workPackage'.
	 */
	public java.lang.String getWorkPackage() {
		return workPackage;
	}
	
	/**
	 * Sets the value of property 'workPackage'.
	 */
	public void setWorkPackage(java.lang.String newValue) {
		this.workPackage = newValue;
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
		Location other = (Location) obj;
		if (getId() != other.getId()) {
			return false;
		}
		return true;
	}
}
