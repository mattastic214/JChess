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
public class Square
{
	private int rowID;
	private int colID;
	private int pixelx;
	private int pixely;
	private ChessPiece occupier;
	
	/**
	 * Initializes an instance of a Square object
	 * @param row
	 * 				The Square object's row
	 * @param col
	 * 				The Square object's column
	 */
	public Square(int row, int col)
	{
		rowID = row;
		colID = col;
		occupier = null;
	}
	
	public int getRowID()
	{
		return rowID;
	}
	
	public int getColID()
	{
		return colID;
	}
	
	public ChessPiece getOccupier()
	{
		return occupier;
	}
	
	public Image getOccupierImage()
	{
		if(occupier != null)
			return occupier.getImage();
		return null;
	}
	
	public void setPixels(Point p)
	{
		pixelx = p.x;
		pixely = p.y;
	}
	
	/**
	 * When a
	 * @param entrant
	 * @throws FriendlyCollisionException 
	 */
	public void setOccupier(ChessPiece entrant) throws FriendlyCollisionException
	{
		this.checkCollision(entrant);
		this.occupier = entrant;
	}
	
	private void vacate()
	{
		occupier = null;
	}
	
	private void checkCollision(ChessPiece entrant)
	{
	
			try
			{
				// Pieces are on the same team
				if(this.getOccupier() != null)
				{
					if(this.getOccupier().getTeam() == entrant.getTeam())
						throw new FriendlyCollisionException();
					// Pieces are on opposite teams
					else if(this.getOccupier().getTeam() != null)
						this.vacate();
				}
				
			} catch (FriendlyCollisionException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
	}
	
	/**
	 * Todo: Chess Square sends piece to another square.
	 */
	public void send(ChessPiece mover, Square dest) throws FriendlyCollisionException
	{
		mover.moveRules(this, dest);
		dest.setOccupier(mover);
		this.vacate();
	}
	
	public void update(Graphics g)
	{
		//g.drawImage(image, x, y, size, size, null);
		
		//g.drawImage(occupier.getImage(), pixelx, pixely, Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		/*
		if(getOccupier() != null)
			g.drawImage((Image)occupier.getImage(), pixelx, pixely, Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		else {
			g.drawImage(null, pixelx, pixely, null);
		}
		*/
	}
	
}
