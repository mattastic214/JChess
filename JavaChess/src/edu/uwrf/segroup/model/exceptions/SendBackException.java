package edu.uwrf.segroup.model.exceptions;

public class SendBackException extends Exception {

	
	/** THIS CLASS IS REDUNDANT!!! DELETE IT NOW!!!
	 * This event handler is responsible for sending a piece to the Square from which it came if
	 * the
	 */
	private static final long serialVersionUID = 1L;

	public SendBackException() {
		super("Move does not conform to rules!");
	}
}
