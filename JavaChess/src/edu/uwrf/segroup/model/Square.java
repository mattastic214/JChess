package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
	private int pixelx;				// The x-coord pixel at which the Square's occupier Icon should be displayed
	private int pixely;				// The x-coord pixel at which the Square's occupier Icon should be displayed
	private ChessPiece occupier;	// The particular Chesspiece that occupies the Square.
	
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
	
	/**
	 * Gets the row number in which the Square is located on the Chess Board
	 * @return the int row number of the Square
	 */
	public int getRowID() {
		return rowID;
	}
	
	/**
	 * Gets the column number in which the Square is located on the Chess Board
	 * @return the int column number of the Square
	 */
	public int getColID() {
		return colID;
	}
	
	/**
	 * Gets the ChessPiece object that is currently occupying the Square
	 * @return The ChessPiece occupying the Square
	 */
	public ChessPiece getOccupier() {
		return occupier;
	}
	
	/**
	 * Gets the ImageIcon of the ChessPiece that is currently occupying the Square
	 * @return the ImageIcon of the occupying ChessPiece.
	 */
	public ImageIcon getOccupierImage() {
		if(occupier != null)
			return occupier.getImage();
		return null;
	}
	
	/**
	 * Sets the pixels where the Square should be displayed
	 * @param p a Point object that represents where the IconImage will be displayed
	 */
	public void setPixels(Point p) {
		pixelx = p.x;
		pixely = p.y;
	}
	
	/**
	 * This method sets the occupier ChessPiece of a the Square
	 * @param entrant a ChessPiece that will be set as the occupier of the Square
	 * @throws FriendlyCollisionException 
	 */
	public void setOccupier(ChessPiece entrant) throws FriendlyCollisionException {
		
		this.checkCollision(entrant);
		
		this.occupier = entrant;
	}
	
	/**
	 * This private method is invoked when a Square sends a ChessPiece from it to another Square.
	 * The method sets the occupier of the Square to null, thus making the Square empty.
	 */
	private void vacate() {
		occupier = null;
	}
	
	/**
	 * This private method is used to check if the ChessPiece entering a Square collides
	 * with another ChessPiece. If the Square is occupied, the method checks if the Square's
	 * occupier is on the same team, if it is, the FriendlyCollisionException event is thrown;
	 * if the pieces are on opposite teams, the Square's occupier vacates the Square.
	 * @param entrant
	 */
	private void checkCollision(ChessPiece entrant) {
	
			try {
				// Check if the Square 
				if(this.getOccupier() != null) {
					// Pieces are on the same team
					if(this.getOccupier().getTeam() == entrant.getTeam())
						throw new FriendlyCollisionException();
					// Pieces are on opposite teams
					else if(this.getOccupier().getTeam() != null)
						this.vacate();
				}
				
			} catch (FriendlyCollisionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
	}
	
	/**
	 * This method sends a Square's occupier to another Square.
	 * @param destination A Square, to where the calling Square's occupier is sent.
	 * @throws FriendlyCollisionException
	 */
	public void send(Square destination) throws FriendlyCollisionException{
		this.occupier.moveRules(this, destination);
		destination.setOccupier(this.occupier);
		this.vacate();
	}
	
	public void update(Graphics g) {
		
		/*
		//g.drawImage(occupier.getImage(), pixelx, pixely, Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		if(getOccupier() != null)
			g.drawImage((Image)occupier.getImage(), pixelx, pixely, Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		else {
			g.drawImage(null, pixelx, pixely, null);
		}*/
	}
	
}
