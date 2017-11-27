package edu.uwrf.segroup.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public abstract class ChessPiece
{
	
	protected Side team;
	protected Image image;
	protected int pixelx;
	protected int pixely;
	
	public ChessPiece(Side setTeam, String imagePath)
	{
		//URL iStream = getClass().getResource(imagePath);
		//image =  new ImageIcon(iStream);
		
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
	
	public Side getTeam()
	{
		return team;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public void setXYPixels()
	{
		pixelx = Settings.SQUARE_DIM / 2;
		pixely = Settings.SQUARE_DIM / 2;
	}
	
	public void setXYPixels(int x, int y)
	{
		pixelx = x;
		pixely = y;
	}
	
	public int getXPixel()
	{
		return pixelx;
	}
	
	public int getYPixel()
	{
		return pixely;
	}
	
	/*
	public void move(Square dest) {
		
		if(!checkFriendlyCollision(dest))
			enforceRules(dest);
	}*/
	
	public abstract void moveRules(Square origin, Square[][] chessboard);
	
	/**
	// Needs to check Side of piece in Square
	protected boolean checkFriendlyCollision(Square dest) {
		
		if(dest.getOccupier().getTeam() == this.getTeam())
			return true;
		else if(dest.getOccupier() != null) {
			dest.setOccupier(null);
			return false;
		}
		return false;
	}
	*/
}
