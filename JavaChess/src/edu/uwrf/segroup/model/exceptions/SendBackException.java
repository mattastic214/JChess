package edu.uwrf.segroup.model.exceptions;

public class SendBackException extends Exception {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendBackException() {
		super("Move does not conform to rules!");
	}
}
