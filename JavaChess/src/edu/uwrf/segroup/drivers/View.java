package edu.uwrf.segroup.drivers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.uwrf.segroup.model.Model;
import edu.uwrf.segroup.model.Settings;
import edu.uwrf.segroup.model.Square;


public class View implements ActionListener {

	private JFrame frame;
	private Model model;
	private JPanel panel;
	private Square[][] set;
	
	@SuppressWarnings("serial")
	private class MyPanel extends JPanel {
	    
		public void paintComponent(Graphics g) {
			model.update(g);
        	revalidate();
        }
    }
	
	
	
	View() {
		System.out.println("View()");	
	
		frame = new JFrame("Chess");
		
		panel = new MyPanel();
		panel.setLayout(new GridLayout(8, 8));


		frame.setSize(Settings.WIDTH, Settings.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);

	} 
	
	public void addController(Controller controller){
		System.out.println("View      : adding controller");
		frame.getContentPane().addMouseListener(controller);
	}
	
	public void addModel(Model model){
		System.out.println("View      : adding model");
		this.model = model;
		set = model.getSquares();
		
		JButton[][] tileButtons = new JButton[Settings.NUM_ROWS][Settings.NUM_COLS];
		
		frame.add(panel);
		for(int row = 0; row < Settings.NUM_ROWS; row++) {
			for(int col = 0; col < Settings.NUM_COLS; col++) {
				tileButtons[row][col] = new JButton();
				
				if((row + col) % 2 != 0)
					tileButtons[row][col].setBackground(Settings.COLOR_BLACK);
				tileButtons[row][col].setIcon((Icon) set[row][col].getOccupierImage());
				panel.add(tileButtons[row][col]);
				tileButtons[row][col].addActionListener(this);
				
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/*
	
	private class ChessGridLayout implements LayoutManager{
		
		private Container contents = new Container();
		private JButton[][] tileButtons = new JButton[Settings.NUM_ROWS][Settings.NUM_COLS];
		
		public ChessGridLayout() {
			super();
			
			
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
		
		
		private class ButtonHandler implements ActionListener{

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
		
		@Override
		public void addLayoutComponent(String arg0, Component arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void layoutContainer(Container arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Dimension minimumLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Dimension preferredLayoutSize(Container arg0) {
			// TODO Auto-generated method stub
			return new Dimension(Settings.SQUARE_DIM, Settings.SQUARE_DIM);
		}

		@Override
		public void removeLayoutComponent(Component arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	*/
	

}