package edu.uwrf.segroup.model;
import java.util.ArrayList;
import java.util.ListIterator;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

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
		
		String pawnColor;
		String rookColor;
		String bishopColor;
		String knightColor;
		String queenColor;
		String kingColor;
		
		if(side == Side.WHITE) {
			pawnColor 		= Settings.WHITE_PAWN_IMAGE;
			rookColor 		= Settings.WHITE_ROOK_IMAGE;
			bishopColor 	= Settings.WHITE_BISHOP_IMAGE;
			knightColor 	= Settings.WHITE_KNIGHT_IMAGE;
			queenColor 		= Settings.WHITE_QUEEN_IMAGE;
			kingColor	 	= Settings.WHITE_KING_IMAGE;
		}
		else {
			pawnColor 		= Settings.BLACK_PAWN_IMAGE;
			rookColor 		= Settings.BLACK_ROOK_IMAGE;
			bishopColor 	= Settings.BLACK_BISHOP_IMAGE;
			knightColor 	= Settings.BLACK_KNIGHT_IMAGE;
			queenColor 		= Settings.BLACK_QUEEN_IMAGE;
			kingColor	 	= Settings.BLACK_KING_IMAGE;
		}
		
		int generated = 0;
		ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();
		
		while(generated < 8) {
			generated++;
			Pawn pawn = new Pawn(side, pawnColor);
			pieces.add(pawn);
		}
		
		Rook rookLeft = new Rook(side, rookColor);
		Knight knightLeft = new Knight(side, knightColor);
		Bishop bishopLeft = new Bishop(side, bishopColor);
		Queen queen = new Queen(side, queenColor);
		King king = new King(side, kingColor);
		Bishop bishopRight = new Bishop(side, bishopColor);
		Knight knightRight = new Knight(side, knightColor);
		Rook rookRight = new Rook(side, rookColor);
			
		pieces.add(rookLeft);
		pieces.add(knightLeft);
		pieces.add(bishopLeft);
		pieces.add(queen);
		pieces.add(king);
		pieces.add(bishopRight);
		pieces.add(knightRight);
		pieces.add(rookRight);
		
		
		return pieces;
	}

	@Override
	public void populateSquares(Square[][] board, ArrayList<ChessPiece> white, ArrayList<ChessPiece> black) throws FriendlyCollisionException {
		
		ListIterator<ChessPiece> IChess = white.listIterator();
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 8; j++) {
				if(IChess.hasNext())
					board[i][j].setOccupier(IChess.next());
			}
		}
		
		IChess = black.listIterator();

		for(int i = 6; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(IChess.hasNext())
					board[i][j].setOccupier(IChess.next());
			}
		}
		
	}

	

	

	

	

	
	
	

}
