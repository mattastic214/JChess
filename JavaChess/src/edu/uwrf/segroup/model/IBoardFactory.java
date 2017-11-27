package edu.uwrf.segroup.model;

import java.util.ArrayList;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * IBoardFactory is a Factory interface for creating
 * ChessBoard objects.
 * <p>
 * An implementation of IBoardFactory is capable of initializing chess games, tuturials, and exercises.
 * @author matta
 *
 */
public interface IBoardFactory {

	public ArrayList<ChessPiece> createWhitePieces();
	public ArrayList<ChessPiece> createBlackPieces();
	public Square[][] createSquares();
	public void populateSquares(Square[][] board, ArrayList<ChessPiece> white, ArrayList<ChessPiece> black) 
			throws FriendlyCollisionException;
	
}
