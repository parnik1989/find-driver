package com.gojek.assignment.model;

/**
 * @author parnik
 * Entity class of Driver table
 */
public class Driver {
	
	private Long id;
	private Double longitude;
	private Double latitude;
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
		return "Driver [id=" + id + ", longitude=" + longitude + ", lattitude=" + latitude + ", accuracy=" + accuracy
				+ "]";
	}
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	

}
