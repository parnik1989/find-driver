package com.gojek.assignment.model;

/*
 * DTO Class for Driver 
 */


public class DriverRequestDTO {

	private Double longitude;
	private Double lattitude;
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
	
	
	
}
