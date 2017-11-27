package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JButton;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * Model is a class that initiates an 
 * instance of a chessboard. It is most like Model in Zombie
 * <p>
 * The class is 
 * responsible for populating the chess board
 * with Squares, white and black ChessPieces,
 * and finally populating the Squares with the
 * appropriate pieces. 
 * @author matta
 *
 */
public class Model
{


	private Square[][] chessboard;
	private ArrayList<ChessPiece> whitePieces;
	private ArrayList<ChessPiece> blackPieces;
	
	/**
	 * A Model constructor.
	 * @param boardFactory The model constructor takes an IBoardFactory Interface as an argument.
	 * The IBoardFactory is responsible for where and which Chess pieces the game, study, or tutorial will have.
	 * @throws FriendlyCollisionException
	 */
	public Model(IBoardFactory boardFactory) throws FriendlyCollisionException
	{
		System.out.println("Model()");
		
		Random r = new Random();
		int random = 0;
		
		random = r.nextInt(2);
		
		this.chessboard = boardFactory.createSquares();
		this.whitePieces = boardFactory.createWhitePieces(random);
		this.blackPieces = boardFactory.createBlackPieces(random);
		
		boardFactory.populateSquares(chessboard, whitePieces, blackPieces, random);
		//this.boardImage = boardFactory.setImage();
	}
	
	/**
	 * 
	 * @return gets the Square[][] chessboard of a Model
	 */
	public Square[][] getSquares()
	{
		return chessboard;
	}
	
	/**
	 * 
	 * @param row Specifies the row number 0-7 of the Square
	 * @param col Specifies the column number 0-7 of the Square
	 * @return gets a particular Square object from the 2-D array chessboard
	 */
	public Square getaSquare(int row, int col)
	{
		return chessboard[row][col];
	}
	
	/**
	 * Upadates the the positions of the ChessPieces on the chess board
	 * @param g
	 */
	public void update(Graphics g)
	{
		
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				if(chessboard[row][col].getOccupierImage() != null)
				{
					chessboard[row][col].getOccupier().moveRules(chessboard[row][col], chessboard);
					chessboard[row][col].update(g);
				}
			}
		}

	}
	
}
