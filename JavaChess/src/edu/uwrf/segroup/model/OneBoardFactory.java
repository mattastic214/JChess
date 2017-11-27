package edu.uwrf.segroup.model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.imageio.ImageIO;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * OneBoardFactory is a class that implements the {@link IBoardFactory}
 * interface.
 * <p>
 * The factory creates {@link Squares}, creates {@link ChessPieces}, and populates the {@link Squares} of a
 * {@link Model} object.
 * @author matta
 *
 */

public class OneBoardFactory implements IBoardFactory
{
	
	/**
	 * Implementation of {@link IBoardFactory#createSquares()}
	 */
	@Override
	public Square[][] createSquares()
	{
		
		Square[][] chessBoard = new Square[Settings.NUM_ROWS][Settings.NUM_COLS];
		
		for(int i = 0; i < Settings.NUM_ROWS; i++)
		{
			for(int j = 0; j < Settings.NUM_COLS; j++)
			{
				chessBoard[i][j] = new Square(i, j);	// Squares are identified by their (rank - 1) on board.
			}
		}
		
		return chessBoard;
	}

	/**
	 * Implementation of {@link IBoardFactory#createPieces(Side)}
	 */
	@Override
	public ArrayList<ChessPiece> createWhitePieces(int random)
	{
		if(random == 0)
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();

			Rook rookLeft = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Queen queen = new Queen(Side.WHITE, Settings.WHITE_QUEEN_IMAGE);
			King king = new King(Side.WHITE, Settings.WHITE_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
				
			pieces.add(rookLeft);
			pieces.add(knightLeft);
			pieces.add(bishopLeft);
			pieces.add(queen);
			pieces.add(king);
			pieces.add(bishopRight);
			pieces.add(knightRight);
			pieces.add(rookRight);
			
			while(generated < 8)
			{
				generated++;
				Pawn pawn = new Pawn(Side.WHITE, Settings.WHITE_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			return pieces;
		}
		else if(random == 1)
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();

			while(generated < 8)
			{
				generated++;
				Pawn pawn = new Pawn(Side.WHITE, Settings.WHITE_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			Rook rookLeft = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Queen queen = new Queen(Side.WHITE, Settings.WHITE_QUEEN_IMAGE);
			King king = new King(Side.WHITE, Settings.WHITE_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
				
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
		else // If you don't want to random, this is default. Exact same code when random == 0.
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();

			Rook rookLeft = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Queen queen = new Queen(Side.WHITE, Settings.WHITE_QUEEN_IMAGE);
			King king = new King(Side.WHITE, Settings.WHITE_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.WHITE, Settings.WHITE_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.WHITE, Settings.WHITE_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.WHITE, Settings.WHITE_ROOK_IMAGE);
				
			pieces.add(rookLeft);
			pieces.add(knightLeft);
			pieces.add(bishopLeft);
			pieces.add(queen);
			pieces.add(king);
			pieces.add(bishopRight);
			pieces.add(knightRight);
			pieces.add(rookRight);
			
			while(generated < 8)
			{
				generated++;
				Pawn pawn = new Pawn(Side.WHITE, Settings.WHITE_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			return pieces;
		}
	}
	
	@Override
	public ArrayList<ChessPiece> createBlackPieces(int random)
	{
		if(random == 0)
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();
			
			while(generated < 8) {
				generated++;
				Pawn pawn = new Pawn(Side.BLACK, Settings.BLACK_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			Rook rookLeft = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Queen queen = new Queen(Side.BLACK, Settings.BLACK_QUEEN_IMAGE);
			King king = new King(Side.BLACK, Settings.BLACK_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
				
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
		else if(random == 1)
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();
			
			Rook rookLeft = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Queen queen = new Queen(Side.BLACK, Settings.BLACK_QUEEN_IMAGE);
			King king = new King(Side.BLACK, Settings.BLACK_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
				
			pieces.add(rookLeft);
			pieces.add(knightLeft);
			pieces.add(bishopLeft);
			pieces.add(queen);
			pieces.add(king);
			pieces.add(bishopRight);
			pieces.add(knightRight);
			pieces.add(rookRight);
			
			while(generated < 8) {
				generated++;
				Pawn pawn = new Pawn(Side.BLACK, Settings.BLACK_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			return pieces;
		}
		else
		{
			int generated = 0;
			ArrayList<ChessPiece> pieces = new ArrayList<ChessPiece>();
			
			while(generated < 8) {
				generated++;
				Pawn pawn = new Pawn(Side.BLACK, Settings.BLACK_PAWN_IMAGE);
				pieces.add(pawn);
			}
			
			Rook rookLeft = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
			Knight knightLeft = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Bishop bishopLeft = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Queen queen = new Queen(Side.BLACK, Settings.BLACK_QUEEN_IMAGE);
			King king = new King(Side.BLACK, Settings.BLACK_KING_IMAGE);
			Bishop bishopRight = new Bishop(Side.BLACK, Settings.BLACK_BISHOP_IMAGE);
			Knight knightRight = new Knight(Side.BLACK, Settings.BLACK_KNIGHT_IMAGE);
			Rook rookRight = new Rook(Side.BLACK, Settings.BLACK_ROOK_IMAGE);
				
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
	}

	@Override
	public void populateSquares(Square[][] board, ArrayList<ChessPiece> white, ArrayList<ChessPiece> black, int random) throws FriendlyCollisionException
	{
		if(random == 0)
		{
			ListIterator<ChessPiece> IChess = white.listIterator();
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
			
			IChess = black.listIterator();

			for(int i = 6; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
		}
		else if(random == 1)
		{
			ListIterator<ChessPiece> IChess = black.listIterator();
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
			
			IChess = white.listIterator();

			for(int i = 6; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
		}
		else
		{
			ListIterator<ChessPiece> IChess = white.listIterator();
			
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
			
			IChess = black.listIterator();

			for(int i = 6; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if(IChess.hasNext())
						board[i][j].setOccupier(IChess.next());
				}
			}
		}
	}
/*
	@Override
	public Image setImage() {
		
		Image image = null;
		try {
			image = ImageIO.read(new File(Settings.CHESS_BOARD_IMAGE));
		} catch (IOException e) {
			System.out.println("Unable to load image file.");
		}
		
		return image;
		
	}
*/


}
