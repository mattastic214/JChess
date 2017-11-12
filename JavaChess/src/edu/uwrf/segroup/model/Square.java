package edu.uwrf.segroup.model;

/**
 * Square is a class that represents a square on a chess board. Square
 * contains information about its location on the board. Square also has 
 * a reference to a {@link ChessPiece} that occupies it.
 * <p>
 * Square checks for collisions that occur if one ChessPiece moves to Square
 * that is already occupied.
 * @author matta
 *
 */
public class Square {

	private int rowID;
	private int colID;
	private ChessPiece occupier;
	
	/**
	 * Initializes an instance of a Square object
	 * @param row
	 * 				The Square object's row
	 * @param col
	 * 				The Square object's column
	 */
	public Square(int row, int col) {
		rowID = row;
		colID = col;
		occupier = null;
	}
	
	
	public int getRowID() {
		return rowID;
	}
	
	public int getColID() {
		return colID;
	}
	
	
	public ChessPiece getOccupier() {
		return occupier;
	}
	
	/**
	 * When a
	 * @param entrant
	 */
	public void setOccupier(ChessPiece entrant) {
		
		if(this.checkCollision())
			;// ToDo: throw an event to reset the piece to its original position
		else
			this.occupier = entrant;
	}
	
	public void vacate() {
		occupier = null;
	}
	
	private boolean checkCollision() {
		
		if(occupier == null)
			return false;
		else 
			return true;
	}
	
}
