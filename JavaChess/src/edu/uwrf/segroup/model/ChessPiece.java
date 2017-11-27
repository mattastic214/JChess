package edu.uwrf.segroup.model;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * The abstract class ChessPiece represents chess pieces in the game of chess. ChessPiece
 * has fields and methods that are common to all extensions of ChessPiece
 * @author matta
 *
 */
public abstract class ChessPiece {
	
	protected Side team;
	protected ImageIcon image;
	
	/**
	 * A constructor for a ChessPiece.
	 * @param setTeam Sets the ChessPiece team to either WHITE or BLACK enum type
	 * @param imagePath The path of the image that is used to represent the ChessPiece.
	 */
	public ChessPiece(Side setTeam, String imagePath) {
		
		URL iStream = getClass().getResource(imagePath);
		image =  new ImageIcon(iStream);
		
		team = setTeam;
		
	}
	
	/**
	 * 
	 * @return Gets the team enum type of the ChessPiece. Can be used
	 * to inform us what color or which side a ChessPiece is on.
	 */
	public Side getTeam() {
		return team;
	}
	
	/**
	 * 
	 * @return Gets the ImageIcon of the ChessPiece.
	 */
	public ImageIcon getImage() {
		
		return image;
	}
	
	/**
	 * This abstract method specifies the rules a ChessPiece should follow when moving
	 * from one Square to another.
	 * @param origin The Square from which a ChessPiece is moving.
	 * @param dest The Square to which a ChessPiece is moving.
	 */
	protected abstract void moveRules(Square origin, Square dest);
	
}
