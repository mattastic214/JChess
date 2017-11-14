package edu.uwrf.segroup.model;
import java.util.ArrayList;

/**
 * OneBoardFactory is a class that implements the {@link IBoardFactory}
 * interface.
 * <p>
 * The factory creates {@link Squares}, creates {@link ChessPieces}, and populates the {@link Squares} of a
 * {@link ChessBoard} object.
 * @author matta
 *
 */
public class OneBoardFactory implements IBoardFactory{

	private final int NUM_ROWS = 8;
	private final int NUM_COLS = 8;
	
	/**
	 * Implementation of {@link IBoardFactory#createSquares()}
	 */
	@Override
	public Square[][] createSquares() {
		
		Square[][] chessBoard = new Square[NUM_ROWS][NUM_COLS];
		
		for(int i = 0; i < NUM_ROWS; i++) {
			for(int j = 0; j < NUM_COLS; i++) {
				chessBoard[i][j] = new Square(i, j);	// Squares are identified by their (rank - 1) on board.
			}
		}
		return chessBoard;
	}

	/**
	 * Implementation of {@link IBoardFactory#createPieces(Side)}
	 */
	@Override
	public ArrayList<ChessPiece> createPieces(Side side) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Implementation of {@link IBoardFactory#populateSquares(Square[][])}
	 */
	@Override
	public void populateSquares(Square[][] set) {
		// TODO Auto-generated method stub
		
	}

	

	

	

	
	
	

}
