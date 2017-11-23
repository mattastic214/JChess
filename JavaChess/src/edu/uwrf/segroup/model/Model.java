package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.awt.Image;
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
	private Image boardImage;
	
	public Model(IBoardFactory boardFactory) throws FriendlyCollisionException {
		System.out.println("Model()");
		
		this.chessboard = boardFactory.createSquares();
		this.whitePieces = boardFactory.createWhitePieces();
		this.blackPieces = boardFactory.createBlackPieces();
		boardFactory.populateSquares(chessboard, whitePieces, blackPieces);
		this.boardImage = boardFactory.setImage();
	}
	
	public void update(Graphics g) {
		
		for(int row = 0; row < Settings.NUM_ROWS; row++) {
			for(int col = 0; col < Settings.NUM_COLS; col++) {
				chessboard[row][col].update(g);
			}
		}
	}
	
	public void setPieces() {
		
	}
}
