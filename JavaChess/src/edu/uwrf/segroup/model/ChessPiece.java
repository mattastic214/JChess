package edu.uwrf.segroup.model;


public abstract class ChessPiece {
	
	protected Side team;
	
	public ChessPiece(Side setTeam) {
		team = setTeam;
	}
	
	public abstract void moveTo(Square dest);
}
