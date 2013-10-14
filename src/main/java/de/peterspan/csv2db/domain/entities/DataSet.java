package de.peterspan.csv2db.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dataset")
/*
 * This class is generated from the entity 'DataSet' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class DataSet {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="acquisitiondate")
	private java.util.Date acquisitionDate;
	
	@Column(name="standingyear")
	private int standingYear;
	
	@Column(name="rotation")
	private int rotation;
	
	@Column(name="clone")
	private int clone;
	
	@Column(name="repetition")
	private int repetition;
	
	@Column(name="treenumber")
	private int treeNumber;
	
	@Column(name="identnumber")
	private java.lang.String identNumber;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="location", nullable=true)
	private Location location;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="measurementvalues", nullable=true)
	private MeasurementValues measurementValues;
	
	@Column(name="remark", length=100000, nullable=true)
	private java.lang.String remark;
	
	@Column(name="inputerror", nullable=true)
	private java.lang.String inputError;
	
	/**
	 * Default constructor. Only used by JPA.
	 */
	public DataSet() {
		super();
	}

	/**
	 * Constructor using all read-only and all non-nullable properties.
	 */
	public DataSet(java.util.Date acquisitionDate, int standingYear, int rotation, int clone, int repetition, int treeNumber, java.lang.String identNumber) {
		super();
		this.acquisitionDate = acquisitionDate;
		this.standingYear = standingYear;
		this.rotation = rotation;
		this.clone = clone;
		this.repetition = repetition;
		this.treeNumber = treeNumber;
		this.identNumber = identNumber;
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
	 * Returns the value of property 'acquisitionDate'.
	 */
	public java.util.Date getAcquisitionDate() {
		return acquisitionDate;
	}
	
	/**
	 * Sets the value of property 'acquisitionDate'.
	 */
	public void setAcquisitionDate(java.util.Date newValue) {
		this.acquisitionDate = newValue;
	}
	
	/**
	 * Returns the value of property 'standingYear'.
	 */
	public int getStandingYear() {
		return standingYear;
	}
	
	/**
	 * Sets the value of property 'standingYear'.
	 */
	public void setStandingYear(int newValue) {
		this.standingYear = newValue;
	}
	
	/**
	 * Returns the value of property 'rotation'.
	 */
	public int getRotation() {
		return rotation;
	}
	
	/**
	 * Sets the value of property 'rotation'.
	 */
	public void setRotation(int newValue) {
		this.rotation = newValue;
	}
	
	/**
	 * Returns the value of property 'clone'.
	 */
	public int getClone() {
		return clone;
	}
	
	/**
	 * Sets the value of property 'clone'.
	 */
	public void setClone(int newValue) {
		this.clone = newValue;
	}
	
	/**
	 * Returns the value of property 'repetition'.
	 */
	public int getRepetition() {
		return repetition;
	}
	
	/**
	 * Sets the value of property 'repetition'.
	 */
	public void setRepetition(int newValue) {
		this.repetition = newValue;
	}
	
	/**
	 * Returns the value of property 'treeNumber'.
	 */
	public int getTreeNumber() {
		return treeNumber;
	}
	
	/**
	 * Sets the value of property 'treeNumber'.
	 */
	public void setTreeNumber(int newValue) {
		this.treeNumber = newValue;
	}
	
	/**
	 * Returns the value of property 'identNumber'.
	 */
	public java.lang.String getIdentNumber() {
		return identNumber;
	}
	
	/**
	 * Sets the value of property 'identNumber'.
	 */
	public void setIdentNumber(java.lang.String newValue) {
		this.identNumber = newValue;
	}
	
	/**
	 * Returns the value of property 'location'.
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Sets the value of property 'location'.
	 */
	public void setLocation(Location newValue) {
		this.location = newValue;
	}
	
	/**
	 * Returns the value of property 'measurementValues'.
	 */
	public MeasurementValues getMeasurementValues() {
		return measurementValues;
	}
	
	/**
	 * Sets the value of property 'measurementValues'.
	 */
	public void setMeasurementValues(MeasurementValues newValue) {
		this.measurementValues = newValue;
	}
	
	/**
	 * Returns the value of property 'remark'.
	 */
	public java.lang.String getRemark() {
		return remark;
	}
	
	/**
	 * Sets the value of property 'remark'.
	 */
	public void setRemark(java.lang.String newValue) {
		this.remark = newValue;
	}
	
	/**
	 * Returns the value of property 'inputError'.
	 */
	public java.lang.String getInputError() {
		return inputError;
	}
	
	/**
	 * Sets the value of property 'inputError'.
	 */
	public void setInputError(java.lang.String newValue) {
		this.inputError = newValue;
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
		DataSet other = (DataSet) obj;
		if (getId() != other.getId()) {
			return false;
		}
		return true;
	}
}
