package edu.uwrf.segroup.model;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.PrivateCredentialPermission;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class ChessGridLayout extends JFrame{
	
	private Container contents;
	private JButton[][] tileButtons = new JButton[Settings.NUM_ROWS][Settings.NUM_COLS];
	
	public ChessGridLayout() {
		super("Does this work?");
		
		contents = getContentPane();
		contents.setLayout(new GridLayout(Settings.NUM_ROWS, Settings.NUM_COLS));
		
		ButtonHandler buttonHandler = new ButtonHandler();
			
		for(int row = 0; row < Settings.NUM_ROWS; row++) {
			for(int col = 0; col < Settings.NUM_COLS; col++) {
				tileButtons[row][col] = new JButton();
				
				if((row + col) % 2 != 0)
					tileButtons[row][col].setBackground(Settings.COLOR_BLACK);
				
				contents.add(tileButtons[row][col]);
				tileButtons[row][col].addActionListener(buttonHandler);
			}
		}
	}
	public void paintComponent(Graphics g) {
		//model.update(g);
    	revalidate();
    }
	
	public class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();
			
			for(int row = 0; row < Settings.NUM_ROWS; row++) {
				for(int col = 0; col < Settings.NUM_COLS; col++) {
					if(source.equals(tileButtons[row][col])) {
						
						
					}
				}
			}
			
		}
	}

}
