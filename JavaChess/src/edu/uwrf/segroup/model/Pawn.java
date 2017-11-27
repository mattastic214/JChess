package edu.uwrf.segroup.model;


public class Pawn extends ChessPiece {

	public Pawn(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveRules(Square origin, Square[][] chessboard)
	{
		if(origin.getFlag() == true)
		{
			for(int row = 0; row < Settings.NUM_ROWS; row++)
			{
				for(int col = 0; col < Settings.NUM_COLS; col++)
				{
					if(chessboard[row][col].getFlag() == true && chessboard[row][col] != origin)
					{
						// Pawn rules here!
						
						break;
					}
				}
			}
		}
		origin.getRowID();
		
	}


}
