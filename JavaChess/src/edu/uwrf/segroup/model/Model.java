package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JButton;

//import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

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
	private int random = 0;
	//private int ActiveSquareCloser = 0;
	private Square ActiveSquare1 = null;
	private Square ActiveSquare2 = null;
	//private Image boardImage;
	
	/**
	 * A Model constructor.
	 * @param boardFactory The model constructor takes an IBoardFactory Interface as an argument.
	 * The IBoardFactory is responsible for where and which Chess pieces the game, study, or tutorial will have.
	 */
	public Model(IBoardFactory boardFactory)
	{
		System.out.println("Model()");
		
		Random r = new Random();
		
		random = r.nextInt(2);
		
		// 0 means white is on top, black is on bottom
		// 1 means black is on top, white is on bottom
		// numbers not 0 or 1 means white is on top, black is on bottom
		
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
	 * This gets a particular Square object form the 2-D array of chessboard.
	 * @param row Specifies the row number 0-7 of the Square.
	 * @param col Specifies the column number 0-7 of the Square.
	 * @return the Square object from specified row and col.
	 */
	public Square getaSquare(int row, int col)
	{
		return chessboard[row][col];
	}
	
	/**
	 * Updates the the positions of the ChessPieces on the chess board.
	 * @param g Graphics object.
	 */
	public void update(Graphics g)
	{
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				if(ActiveSquare1 == null || ActiveSquare2 == null)
				{
					for(int row2 = 0; row2 < Settings.NUM_ROWS; row2++)
					{
						for(int col2 = 0; col2 < Settings.NUM_COLS; col2++)
						{
							if(chessboard[row2][col2].getFlag() == true && ActiveSquare1 == null && ActiveSquare2 == null)
							{
								System.out.println("Active1");
								ActiveSquare1 = chessboard[row2][col2];
							}
							if(ActiveSquare1 != null)
							{
								if(chessboard[ActiveSquare1.getRowID()][ActiveSquare1.getColID()].getFlag() == false)
								{
									System.out.println("Deactive1");
									ActiveSquare1 = null;
								}
							}
							if(chessboard[row2][col2].getFlag() == true && ActiveSquare1 != null && ActiveSquare2 == null && ActiveSquare1 != chessboard[row2][col2])
							{
								System.out.println("Active2");
								ActiveSquare2 = chessboard[row2][col2];
							}
						}
					}
				}
				
				
				if(ActiveSquare1 != null && ActiveSquare2 != null)
				{
					if(ActiveSquare1.getOccupierImage() != null)
					{
						chessboard[ActiveSquare1.getRowID()][ActiveSquare1.getColID()].getOccupier().moveRules(chessboard[ActiveSquare1.getRowID()][ActiveSquare1.getColID()], chessboard, random);
						chessboard[ActiveSquare1.getRowID()][ActiveSquare1.getColID()].update(g);
					}
					chessboard[ActiveSquare1.getRowID()][ActiveSquare1.getColID()].setFlag(false);
					chessboard[ActiveSquare2.getRowID()][ActiveSquare2.getColID()].setFlag(false);
					ActiveSquare1 = null;
					ActiveSquare2 = null;
					System.out.println("Reset");
				}
				
				if(chessboard[row][col].getOccupierImage() != null)
				{
					chessboard[row][col].update(g);
				}
			}
		}

	}
	
}
