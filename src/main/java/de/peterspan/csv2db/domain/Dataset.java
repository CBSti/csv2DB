package de.peterspan.csv2db.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Dataset implements Serializable{

	private static final long serialVersionUID = -9069619437033950664L;
	
	public Location mLocation;
	public Values mValues;
	
	public Location getLocation() {
		return mLocation;
	}
	public void setLocation(Location mLocation) {
		this.mLocation = mLocation;
	}
	public Values getValues() {
		return mValues;
	}
	public void setValues(Values mValues) {
		this.mValues = mValues;
	}
	
	
}
