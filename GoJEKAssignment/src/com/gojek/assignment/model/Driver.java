package com.gojek.assignment.model;

public class Driver {
	
	private Long id;
	private Double longitude;
	private Double lattitude;
	private Double accuracy;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the lattitude
	 */
	public Double getLattitude() {
		return lattitude;
	}
	/**
	 * @param lattitude the lattitude to set
	 */
	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}
	/**
	 * @return the accuracy
	 */
	public Double getAccuracy() {
		return accuracy;
	}
	/**
	 * @param accuracy the accuracy to set
	 */
	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Driver [id=" + id + ", longitude=" + longitude + ", lattitude=" + lattitude + ", accuracy=" + accuracy
				+ "]";
	}
	
	

}
