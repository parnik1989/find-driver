package com.gojek.assignment.model;


/**
 * @author parnik
 * DTO object of driver to get the request from HTTP server or UI
 */
public class DriverRequestDTO {

	private Double longitude;
	private Double latitude;
	private Double accuracy;
	private Long userId;
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
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DriverRequestDTO [longitude=" + longitude + ", latitude=" + latitude + ", accuracy=" + accuracy
				+ ", userId=" + userId + "]";
	}
	
	
	
}
