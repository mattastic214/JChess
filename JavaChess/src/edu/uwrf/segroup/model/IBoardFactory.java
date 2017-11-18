package edu.uwrf.segroup.model;

import java.util.ArrayList;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * IBoardFactory is a Factory interface for creating
 * ChessBoard objects.
 * @author matta
 *
 */
public interface IBoardFactory {

	public ArrayList<ChessPiece> createPieces(Side side);
	public Square[][] createSquares();
	public void populateSquares(Square[][] board, ArrayList<ChessPiece> white, ArrayList<ChessPiece> black) throws FriendlyCollisionException;
}
