package edu.uwrf.segroup.model.exceptions;

public class FriendlyCollisionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FriendlyCollisionException() {
		
		super("Can't move there!");
		
	}
}
