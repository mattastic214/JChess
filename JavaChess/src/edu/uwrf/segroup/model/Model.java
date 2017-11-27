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
	int random = 0;
	//private Image boardImage;
	
	public Model(IBoardFactory boardFactory) throws FriendlyCollisionException
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
	
	public Square[][] getSquares()
	{
		return chessboard;
	}
	
	public Square getaSquare(int row, int col)
	{
		return chessboard[row][col];
	}
	
	public void update(Graphics g)
	{
		
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				if(chessboard[row][col].getOccupierImage() != null)
				{
					chessboard[row][col].getOccupier().moveRules(chessboard[row][col], chessboard, random);
					chessboard[row][col].update(g);
				}
			}
		}

	}
	
}
