package edu.uwrf.segroup;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class ChessGUI  extends JFrame implements ActionListener{

	private static final int HEIGHT = 700;
	private static final int WIDTH = 600;
	
	private URL url = ChessGUI.class.getResource("/resources/chessboard.png");
	
	/**
	 * The null constructor for the GUI
	 */
	public ChessGUI() {
		
		super("Chess Lounge");
		setVisible(true);
		setSize(HEIGHT, WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
