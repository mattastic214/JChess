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

	
	private JPanel boardPanel = new JPanel();
	private JPanel chatPanel = new JPanel(new GridLayout(2, 1, GAP, GAP));
	//	Declare Variables --END--
	/**
	 * The null constructor for the GUI
	 */

	public ChessGUI()
	{
		super("Chess Lounge"); // this.setTitle("Chess Lounge");
		setSize(WIDTH, HEIGHT); // this.setSize(1500, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true); // this.setVisible(true);
		setLayout(new GridLayout(1, 2));
		setResizable(false); // this.setResizable(false);

		addBoardPanel();
		initializeGuiComponents();
		
		
	}
	
	private void addBoardPanel() {
		
		boardPanel.add(boardIcon);
		add(boardPanel);

		
	}
	
	private void initializeGuiComponents() {
		
		chatPanel.add(chatDisplay);
		chatPanel.add(chatEnter);

		add(chatPanel);
	}

	
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