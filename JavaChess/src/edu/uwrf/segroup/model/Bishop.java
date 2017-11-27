package edu.uwrf.segroup.model;

import edu.uwrf.segroup.model.exceptions.SendBackException;

public class Bishop extends ChessPiece{

	public Bishop(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveRules(Square origin, Square[][] chessboard, int random) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	protected void moveRules(Square origin, Square dest) {
		
		int xDifference = origin.getColID() - dest.getColID();
		int yDifference = origin.getRowID() - dest.getRowID();
		
		 
		try {
			if(Math.abs(xDifference) != Math.abs(yDifference))
				throw new SendBackException();
		} catch (SendBackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/

}
