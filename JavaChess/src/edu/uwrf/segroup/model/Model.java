package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.util.ArrayList;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * Model is a class that initiates an 
 * instance of a chessboard. It is most like Model in Zombie
 * <p>
 * The class is 
 * responsible for populating the chess board
 * with Squares, white and black ChessPieces,
 * and finally populating the Squares with the
 * appropriate pieces. 
 * @author matta
 *
 */
public class Model {

	private Square[][] chessboard;
	private ArrayList<ChessPiece> whitePieces;
	private ArrayList<ChessPiece> blackPieces;
	
	public Model(IBoardFactory boardFactory) throws FriendlyCollisionException {
		System.out.println("Model()");
		
		this.chessboard = boardFactory.createSquares();
		this.whitePieces = boardFactory.createPieces(Side.WHITE);
		this.blackPieces = boardFactory.createPieces(Side.BLACK);
		boardFactory.populateSquares(chessboard, whitePieces, blackPieces);
		
	}
	
	public void update(Graphics g) {
		
		
	}
}
