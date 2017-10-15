package edu.uwrf.segroup;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

/**
 * This class' purporse is to properly initialize the GUI and its features
 * @author matta
 *
 */
public class ChessGUI  extends JFrame implements ActionListener{

	private static final int HEIGHT = 700;
	private static final int WIDTH = 600;
	
	// The image of the chessboard we will use
	private URL url = ChessGUI.class.getResource("/resources/chessboard.png");
	private ImageIcon board = new ImageIcon(url);
	private JLabel boardIcon = new JLabel(board);
	
	/**
	 * The null constructor for the GUI
	 */
	public ChessGUI() {
		
		super("Chess Lounge");
		setVisible(true);
		setSize(HEIGHT, WIDTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		initializeGuiComponents();
	}
	
	private void initializeGuiComponents() {
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
