package edu.uwrf.segroup;

import java.net.URL;
import javax.swing.*;

public class ChessBoard {

	private static final int BORDER_DIM = 24;
	private static final int HALFSQUARE_DIM = 41;
	private static final int SQUARE_DIM = 83;
	private static final int BORDERSQUARE_DIM = 65;
	private static final int CHESSBOARD_DIM = 720;
	
	private URL ImageSource;
	private ImageIcon Image;
	private JLabel Container;
	private Square [] Squares;
	
	private ChessListener [] SquareListener;
	
	public ChessBoard()
	{
		ImageSource = ChessBoard.class.getResource("/resources/chessboard.png");
		Image = new ImageIcon(ImageSource);
		Container = new JLabel(Image);
		Squares = new Square[64];
		SquareListener = new ChessListener[64];
		SquareListener[0] = new ChessListener();
		SquareListener[1] = new ChessListener();
		
		Squares[0] = new Square();
		Squares[1] = new Square();
		
		Squares[0].getContainer().setSize(SQUARE_DIM, SQUARE_DIM);
		Squares[1].getContainer().setSize(SQUARE_DIM, SQUARE_DIM);
		
		Squares[0].getContainer().setLocation((BORDERSQUARE_DIM - HALFSQUARE_DIM), ((CHESSBOARD_DIM - (BORDERSQUARE_DIM + 2 * SQUARE_DIM)) - HALFSQUARE_DIM));
		Squares[1].getContainer().setLocation((BORDERSQUARE_DIM - HALFSQUARE_DIM), ((CHESSBOARD_DIM - (BORDERSQUARE_DIM + 3 * SQUARE_DIM)) - HALFSQUARE_DIM));
		
		Squares[0].getContainer().addMouseListener(SquareListener[0]);
		Squares[1].getContainer().addMouseListener(SquareListener[1]);

		/*
		for(int i = 0; i < Squares.length; i++)
		{
			Squares[i] = new Square();
			Squares[i].getContainer().setSize(83, 83);
			//Squares[i].getContainer().setLocation(x, y);
		}
		*/
	}
	
	public JLabel getContainer()
	{
		return Container;
	}
	
	public JLabel getSquareContainer(int i)
	{
		return Squares[i].getContainer();
	}
	
	public ChessListener getSquareListener(int i)
	{
		return SquareListener[i];
	}
	
}
