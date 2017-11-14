package edu.uwrf.segroup.model;


public abstract class ChessPiece {
	
	protected Side team;
	private Square location;
	
	public ChessPiece(Side setTeam, Square start) {
		team = setTeam;
		location = start;
	}
	
	public Side getTeam() {
		return team;
	}
	
	public Square getLocation() {
		return location;
	}
	
	/*
	public void move(Square dest) {
		
		if(!checkFriendlyCollision(dest))
			enforceRules(dest);
	}*/
	
	protected abstract void moveRules(Square dest);
	
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
