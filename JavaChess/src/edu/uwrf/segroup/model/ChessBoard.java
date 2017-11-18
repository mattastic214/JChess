package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.util.ArrayList;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * ChessBoard is a class that initiates an 
 * instance of a chess board. It is most like Model in Zombie
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
	
	public ChessBoard(IBoardFactory boardFactory) throws FriendlyCollisionException {
		System.out.println("Model()");
		
		this.squares = boardFactory.createSquares();
		this.whitePieces = boardFactory.createPieces(Side.WHITE);
		this.blackPieces = boardFactory.createPieces(Side.BLACK);
		boardFactory.populateSquares(squares, whitePieces, blackPieces);
		
	}
	
	public void update(Graphics g) {
		
	}
}
