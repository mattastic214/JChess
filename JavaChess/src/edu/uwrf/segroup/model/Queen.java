package edu.uwrf.segroup.model;

/**
 * The Queen Piece which extends the ChessPiece object.
 * @author matta, charles
 *
 */
public class Queen extends ChessPiece {

	/**
	 * The constructor of the Queen class.
	 * @param setTeam Sets the ChessPiece team to either WHITE or BLACK enum type
	 * @param imagePath The path of the image that is used to represent the ChessPiece.
	 * @author matta, charles
	 */
	public Queen(Side setTeam, String imagePath) {
		super(setTeam, imagePath);
		// TODO Auto-generated constructor stub
	}

	/**
	 * The movesets of the Queen Piece
	 * @param origin
	 * 				The Square the ChessPiece is occupying.
	 * @param chessboard
	 * 				The chessboard itself containing all the squares, used to detect a 2nd active Square.
	 * @param random
	 * 				Determination of movesets based on the orientation of the board and players. Used specifically for Pawn.
	 * @author matta, charles
	 */
	@Override
	public void moveRules(Square origin, Square[][] chessboard, int random) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	protected void moveRules(Square origin, Square dest) {
		// TODO Auto-generated method stub
		
	}

	*/

}
