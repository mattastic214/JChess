package edu.uwrf.segroup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

/**
 * This class's purpose is to properly initialize the GUI and its features
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
	
	private JButton sendButton = new JButton("Send");
	private JButton confirmButton = new JButton("Confirm Move");
	private JButton originButton = new JButton("Send Piece Back To Place");
	
	private JTextArea chatDisplay = new JTextArea(10, 3);
	private JTextArea chatEnter = new JTextArea(10,3);
	
	private JPanel boardPanel = new JPanel(new BorderLayout());
	private JPanel chatPanel = new JPanel(new GridLayout(2, 1));
	
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
		
		
		
		add(boardPanel, BorderLayout.CENTER);
		add(chatPanel, BorderLayout.WEST);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
