package edu.uwrf.segroup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.net.URL;
import java.awt.Container;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.*;

import javax.swing.*;

/**
 * This class's purpose is to properly initialize the GUI and its features
 * @author matta
 *
 */

public class ChessGUI extends JFrame implements Runnable {

	//	Declare Variables --START--
	private static final int HEIGHT = 900;
	private static final int WIDTH = 1500;
	private static final int GAP = 3;
	//private static final int CHESSPIECESIZE = 76;
	//private static final int CHESSPIECEHALFSIZE = CHESSPIECESIZE / 2;
	/*
	// The image of the chessboard we will use
	private URL chessboard = ChessGUI.class.getResource("/resources/chessboard.png");
	private URL pawn = ChessGUI.class.getResource("/resources/pawn.png");
	private ImageIcon board = new ImageIcon(chessboard);
	private JLabel boardIcon = new JLabel(board);
	
	private JButton sendButton = new JButton("Send");
	private JButton confirmButton = new JButton("Confirm Move");
	private JButton originButton = new JButton("Send Piece Back To Place");
	
	private JTextArea chatDisplay = new JTextArea(10, 3);
	private JTextArea chatEnter = new JTextArea(10, 3);
	*/
	
	//private JPanel boardPanel = new JPanel(null);
	//private JPanel chatPanel = new JPanel(new GridLayout(2, 1, GAP, GAP));
	/*
	private URL chessboard;
	private URL pawn;
	private ImageIcon board;
	private ImageIcon pawnpiece;
	private JLabel boardIcon;
	private JLabel pawnIcon;
	*/
	private JButton sendButton;
	private JButton confirmButton;
	private JButton originButton;
	
	private JTextArea chatDisplay;
	private JTextArea chatEnter;
	
	private ChessGame ChessGame;
	
	//	Declare Variables --END--
	/**
	 * The null constructor for the GUI
	 */

	public ChessGUI()
	{
		/*
		chessboard = ChessGUI.class.getResource("/resources/chessboard.png");
		pawn = ChessGUI.class.getResource("/resources/pawn.png");
		board = new ImageIcon(chessboard);
		boardIcon = new JLabel(board);
		pawnpiece = new ImageIcon(pawn);
		pawnIcon = new JLabel(pawnpiece);
		*/
		ChessGame = new ChessGame();
		
		sendButton = new JButton("Send");
		confirmButton = new JButton("Confirm Move");
		originButton = new JButton("Send Piece Back to Place");
		
		sendButton.addActionListener(new sendButton());
		confirmButton.addActionListener(new confirmButton());
		originButton.addActionListener(new originButton());
		
		chatDisplay = new JTextArea(10, 3);
		chatEnter = new JTextArea(10, 3);
		/*
		boardIcon.setSize(720, 720);
		boardIcon.setLocation(0, 0);
		pawnIcon.setSize(CHESSPIECESIZE, CHESSPIECESIZE);
		pawnIcon.setLocation((65 - CHESSPIECEHALFSIZE), (572 - CHESSPIECEHALFSIZE));
		*/
		sendButton.setSize(150 ,24);
		sendButton.setLocation(65, 65);
		/*
		Container pane = getContentPane();
		pane.setLayout(null);
		
		pane.add(boardIcon);
		pane.add(sendButton);
		*/
		this.setTitle("Chess Lounge");// this.setTitle("Chess Lounge");
		this.setSize(WIDTH, HEIGHT); // this.setSize(1500, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true); // this.setVisible(true);
		//setLayout(new GridLayout(1, 2));
		this.setResizable(false); // this.setResizable(false);
		
		add(ChessGame.getChessGameContainer());
		
		//addBoardPanel();
		//initializeGuiComponents();
		
	}
	/*
	private void addBoardPanel() {
		
		//boardPanel.add(boardIcon);
		boardPanel.add(pawnIcon);
		boardPanel.add(boardIcon);
		boardIcon.setLocation(0, 10);
		boardIcon.setSize(720, 720);
		add(boardPanel);
		
	}
	*/
	/*
	private void initializeGuiComponents() {
		
		chatPanel.add(chatDisplay);
		chatPanel.add(chatEnter);

		add(chatPanel);
	}
*/
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	private class sendButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class confirmButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class originButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}