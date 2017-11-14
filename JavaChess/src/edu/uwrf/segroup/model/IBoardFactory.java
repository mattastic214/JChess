package edu.uwrf.segroup.model;

import java.util.ArrayList;

/**
 * IBoardFactory is a Factory interface for creating
 * ChessBoard objects.
 * @author matta
 *
 */
public interface IBoardFactory {

	public Square[][] createSquares();
	public ArrayList<ChessPiece> createPieces(Side side);
	public void populateSquares(Square[][] set);
}
