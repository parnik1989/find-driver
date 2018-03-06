package com.gojek.assignment.model;

/**
 * @author parnik
 * DTO class to send the request to receive nearby driver's details
 */
public class UserRequestDTO {
	private Double longitude;
	private Double lattitude;
	private Double radius;
	private Long limit;
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
	 * @return the radius
	 */
	public Double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(Double radius) {
		this.radius = radius;
	}
	/**
	 * @return the limit
	 */
	public Long getLimit() {
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(Long limit) {
		this.limit = limit;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " longitude=" + longitude + ", lattitude=" + lattitude + ", radius=" + radius + ", limit="
				+ limit ;
	}
	
	
}
