package edu.uwrf.segroup.model;

public class Square {

	private ChessPiece occupier;
	
	public Square() {
		occupier = null;
	}
	
	public ChessPiece getOccupier() {
		return occupier;
	}
	
	public void setOccupier(ChessPiece entrant) {
		this.occupier = entrant;
	}
	
	public void vacate() {
		occupier = null;
	}
	
}
