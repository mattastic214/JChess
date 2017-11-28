package edu.uwrf.segroup.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The abstract class ChessPiece represents chess pieces in the game of chess. ChessPiece
 * has fields and methods that are common to all extensions of ChessPiece
 * @author matta
 *
 */
public abstract class ChessPiece
{
	
	protected Side team;
	protected Image image;
	protected int pixelx;
	protected int pixely;
	
	/**
	 * A constructor for a ChessPiece.
	 * @param setTeam Sets the ChessPiece team to either WHITE or BLACK enum type
	 * @param imagePath The path of the image that is used to represent the ChessPiece.
	 */
	public ChessPiece(Side setTeam, String imagePath)
	{
		
		try
		{
	    	image = ImageIO.read(new File(imagePath));
	    	System.out.println("Image loaded.");
	    } catch (IOException ioe) {
	    	System.out.println("Unable to load image file.");
	    }
		
		team = setTeam;
		setXYPixels();
	}
	
	/**
	 * 
	 * @return Gets the team enum type of the ChessPiece. Can be used
	 * to inform us what color or which side a ChessPiece is on.
	 */
	public Side getTeam()
	{
		return team;
	}
	
	/**
	 * 
	 * @return Gets the Image of the ChessPiece.
	 */
	public Image getImage()
	{
		return image;
	}
	
	/**
	 * A default setter for placing the image of a ChessPiece on a Square
	 */
	public void setXYPixels()
	{
		pixelx = Settings.SQUARE_DIM / 2;
		pixely = Settings.SQUARE_DIM / 2;
	}
	
	/**
	 * Manually set the pixels of where a ChessPieces image should be displayed on
	 * a Square
	 * @param x the x-coordinate pixel
	 * @param y the y-coordinate pixel
	 */
	public void setXYPixels(int x, int y)
	{
		pixelx = x;
		pixely = y;
	}
	
	/**
	 * 
	 * @return The x-coordinate pixel
	 */
	public int getXPixel()
	{
		return pixelx;
	}
	
	/**
	 * 
	 * @return The y-coordinate pixel
	 */
	public int getYPixel()
	{
		return pixely;
	}
	
	/**
	 * An abstract method, when implemented will designate the rules of how a
	 * piece should move.
	 * @param origin The Square at which the ChessPiece starts/moves from
	 * @param chessboard The chessboard that represents the game
	 * @param random
	 */
	public abstract void moveRules(Square origin, Square[][] chessboard, int random);
	
}
