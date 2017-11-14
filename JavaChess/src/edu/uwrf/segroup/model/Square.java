package edu.uwrf.segroup.model;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

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
	 * @throws FriendlyCollisionException 
	 */
	public void setOccupier(ChessPiece entrant) throws FriendlyCollisionException {
		
		this.checkCollision(entrant);
		
		this.occupier = entrant;
	}
	
	public void vacate() {
		occupier = null;
	}
	
	private void checkCollision(ChessPiece entrant) {
		
		if(this.getOccupier().getTeam() == entrant.getTeam())
		{
			try {
				throw new FriendlyCollisionException();
			} catch (FriendlyCollisionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
