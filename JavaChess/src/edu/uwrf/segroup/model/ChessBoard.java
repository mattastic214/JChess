package edu.uwrf.segroup.model;

import java.util.ArrayList;

/**
 * ChessBoard is a class that initiates an 
 * instance of a chess board. 
 * <p>
 * The class is 
 * responsible for populating the chess board
 * with Squares, white and black ChessPieces,
 * and finally populating the Squares with the
 * appropriate pieces. 
 * @author matta
 *
 */
public class ChessBoard {

	private Square[][] squares;
	private ArrayList<ChessPiece> whitePieces;
	private ArrayList<ChessPiece> blackPieces;
	
	public ChessBoard(IBoardFactory boardFactory) {
		
		this.squares = boardFactory.createSquares();
		this.whitePieces = boardFactory.createPieces(Side.WHITE);
		this.blackPieces = boardFactory.createPieces(Side.BLACK);
		boardFactory.populateSquares(this.squares);
	}
}
