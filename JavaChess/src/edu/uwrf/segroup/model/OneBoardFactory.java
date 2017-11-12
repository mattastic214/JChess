package edu.uwrf.segroup.model;
import java.util.ArrayList;

public class OneBoardFactory implements IBoardFactory{

	private final int NUM_ROWS = 8;
	private final int NUM_COLS = 8;
	
	
	@Override
	public Square[][] createSquares() {
		
		Square[][] chessBoard = new Square[NUM_ROWS][NUM_COLS];
		
		for(int i = 0; i < NUM_ROWS; i++) {
			for(int j = 0; j < NUM_COLS; i++) {
				chessBoard[i][j] = new Square();
			}
		}
		return chessBoard;
	}

	@Override
	public ArrayList<ChessPiece> createWhite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChessPiece> createBlack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void populateSquares() {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
