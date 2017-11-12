package edu.uwrf.segroup.model;

import java.util.ArrayList;

public interface IBoardFactory {

	public Square[][] createSquares();
	public ArrayList<ChessPiece> createWhite();
	public ArrayList<ChessPiece> createBlack();
	public void populateSquares();
}
