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
	private ChessPiece occupier;
	private JButton button;
	private boolean flag;
	
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
		button = new JButton();
		flag = false;
	}
	
	/**
	 * Gets the row number in which the Square is located on the Chess Board
	 * @return the int row number of the Square
	 */
	public int getRowID()
	{
		return rowID;
	}
	
	/**
	 * Gets the column number in which the Square is located on the Chess Board
	 * @return the int column number of the Square
	 */
	public int getColID()
	{
		return colID;
	}
	
	public boolean getFlag()
	{
		return flag;
	}
	
	public void setFlag(boolean flag)
	{
		this.flag = flag;
	}
	
	/**
	 * Gets the ChessPiece object that is currently occupying the Square
	 * @return The ChessPiece occupying the Square
	 */
	public ChessPiece getOccupier()
	{
		return occupier;
	}
	
	/**
	 * Gets the ImageIcon of the ChessPiece that is currently occupying the Square
	 * @return the ImageIcon of the occupying ChessPiece.
	 */
	public Image getOccupierImage()
	{
		if(occupier != null)
		{
			//System.out.println("Test!");
			return occupier.getImage();
		}
		else
			return null;
	}
	
	/*
	public void setPixels(int x, int y)
	{
		if(occupier != null)
		{
			occupier.setXYPixels(x, y);
		}
	}
	*/
	
	/**
	 * This method sets the occupier ChessPiece of a the Square.
	 * @param entrant
	 * @throws FriendlyCollisionException 
	 */
	public void setOccupier(ChessPiece entrant)
	{
		//this.checkCollision(entrant);
		this.occupier = entrant;
	}
	
	
	public void setImageIcon()
	{
		if(occupier != null && occupier.getImage() != null)
		{
			ImageIcon temp = new ImageIcon(occupier.getImage());
			button.setIcon(temp);
		}
		else if(occupier == null)
			button.setIcon(null);
	}
	
	/*
	public void setImageIcon(Image image)
	{
		if(occupier != null && image != null)
		{
			ImageIcon temp = new ImageIcon(image);
			button.setIcon(temp);
		}
	}
	
	
	public Icon getIcon()
	{
		if(occupier != null && occupier.getImage() != null)
		{
			return button.getIcon();
		}
		else
			return null;
	}
	*/
	
	public JButton getButton()
	{
		return button;
	}
	

	public void vacate()
	{
		occupier = null;
	}
	
	/**
	 * This private method is used to check if the ChessPiece entering a Square collides
	 * with another ChessPiece. If the Square is occupied, the method checks if the Square's
	 * occupier is on the same team, if it is, the FriendlyCollisionException event is thrown;
	 * if the pieces are on opposite teams, the Square's occupier vacates the Square.
	 * @param entrant
	 */
	private void checkCollision(ChessPiece entrant)
	{
	
			try
			{
				// Is the Square occupied?
				if(this.getOccupier() != null)
				{
					// Check if ChessPieces are on the same team
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
	/*
	public void send(ChessPiece mover, Square dest) throws FriendlyCollisionException
	{
		mover.moveRules(this, dest);
		dest.setOccupier(mover);
		this.vacate();
	}
	*/
	
	public void update(Graphics g)
	{
		//g.drawImage(occupier.getImage(), occupier.getXPixel(), occupier.getYPixel(), Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		setImageIcon();
		//g.drawImage(image, x, y, size, size, null);
		/*
		if(getOccupier() != null)
			g.drawImage((Image)occupier.getImage(), pixelx, pixely, Settings.SQUARE_DIM, Settings.SQUARE_DIM, null);
		else {
			g.drawImage(null, pixelx, pixely, null);

		}
		*/
	}
	
}
