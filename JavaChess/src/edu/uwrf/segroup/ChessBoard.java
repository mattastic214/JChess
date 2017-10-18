package edu.uwrf.segroup;

public class ChessBoard {

	private XYLocation [] Squares;
	
	public ChessBoard()
	{
		Squares = new XYLocation[64];
		for(int i = 0; i < Squares.length; i++)
		{
			Squares[i] = new XYLocation();
		}
	}
	
}
