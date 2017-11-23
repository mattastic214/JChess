package edu.uwrf.segroup.model;

import java.net.URL;

import javax.swing.ImageIcon;

public abstract class ChessPiece {
	
	protected Side team;
	protected ImageIcon image;
	
	public ChessPiece(Side setTeam, String imagePath) {
		
		
		URL iStream = getClass().getResource(imagePath);
		image =  new ImageIcon(iStream);
		
		team = setTeam;
		
	}
	
	public Side getTeam() {
		return team;
	}
	
	public ImageIcon getImage() {
		
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
