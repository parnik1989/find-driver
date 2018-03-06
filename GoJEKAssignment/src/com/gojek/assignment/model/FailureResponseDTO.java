package com.gojek.assignment.model;

/**
 * @author parnik
 *  Failure response to HTTP Server in case of wrong URL or wrong entity values
 *
 */
public class FailureResponseDTO implements ResponseDTO {

	private String message;
	
	public FailureResponseDTO(String message){
		this.setMessage(message);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
