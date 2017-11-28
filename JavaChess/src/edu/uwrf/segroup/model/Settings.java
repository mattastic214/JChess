package edu.uwrf.segroup.model;

import java.awt.Color;

/**
 * Settings is a place to store our public final variables of sizes, colors, and images.
 * @author matta, charles
 *
 */
public final class Settings {

	private Settings() {};
	
	public static final int WIDTH = 725;
	public static final int HEIGHT = 750;
	
	public static final Color COLOR_BLACK = Color.black;
	public static final Color COLOR_WHITE = Color.white;
	
	public static final int NUM_ROWS = 8;
	public static final int NUM_COLS = 8;
	public static final int SQUARE_DIM = 83;
	

	public static final String WHITE_PAWN_IMAGE		= "Pawn.png";
	public static final String WHITE_BISHOP_IMAGE	= "White Bishop.png";
	public static final String WHITE_KING_IMAGE		= "White King.png";
	public static final String WHITE_KNIGHT_IMAGE	= "White Knight.png";
	public static final String WHITE_QUEEN_IMAGE	= "White Queen.png";
	public static final String WHITE_ROOK_IMAGE		= "White Rook.png";
	
	public static final String BLACK_PAWN_IMAGE		= "Black Pawn.png";
	public static final String BLACK_BISHOP_IMAGE	= "Black Bishop.png";
	public static final String BLACK_KING_IMAGE		= "Black King.png";
	public static final String BLACK_KNIGHT_IMAGE	= "Black Knight.png";
	public static final String BLACK_QUEEN_IMAGE	= "Black Queen.png";
	public static final String BLACK_ROOK_IMAGE		= "Black Rook.png";
	
	public static final String CHESS_BOARD_IMAGE	= "/resources/chessboard.png";
}
