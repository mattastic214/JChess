package edu.uwrf.segroup;

public class ChessGame {
	
	private ChessBoard ChessBoard;
	private ChessPiece [] ChessPieces;
	private Player [] Players;
	
	public ChessGame()
	{
		ChessBoard = new ChessBoard();
		ChessPieces = new ChessPiece[32];
		Players = new Player[2];
	}

}
