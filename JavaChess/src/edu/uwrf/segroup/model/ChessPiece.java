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
	
	public ChessPiece(Side setTeam, String imagePath)
	{
		//URL iStream = getClass().getResource(imagePath);
		//image =  new ImageIcon(iStream);
		
		try
		{
	    	image = ImageIO.read(new File(imagePath));
	    } catch (IOException ioe) {
	    	System.out.println("Unable to load image file.");
	    }
		
		team = setTeam;
	}
	
	public Side getTeam()
	{
		return team;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	
	/*
	public void move(Square dest) {
		
		if(!checkFriendlyCollision(dest))
			enforceRules(dest);
	}*/
	
	protected abstract void moveRules(Square origin, Square dest);
	
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
