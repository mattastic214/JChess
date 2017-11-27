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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.uwrf.segroup.model.Model;
import edu.uwrf.segroup.model.Settings;
import edu.uwrf.segroup.model.Square;

/**
 * View is responsible for displaying the Chessboard game to the users
 * @author matta
 *
 */
public class View implements ActionListener
{

	private JFrame frame;		
	private Model model;
	private JPanel panel;
	private Square[][] set;
	
	@SuppressWarnings("serial")
	private class MyPanel extends JPanel
	{
	    
		public void paintComponent(Graphics g)
		{
			model.update(g);
        	revalidate();
        }
    }
	

	View()
	{
		System.out.println("View()");	
	
		frame = new JFrame("Chess");
		
		panel = new MyPanel();
		panel.setLayout(new GridLayout(8, 8));


		frame.setSize(Settings.WIDTH, Settings.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);

	} 
	
	public void addController(Controller controller)
	{
		System.out.println("View      : adding controller");
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				model.getaSquare(row, col).getButton().addActionListener(controller);
			}
		}
	}
	
	public void addModel(Model model)
	{
		System.out.println("View      : adding model");
		this.model = model;
		set = model.getSquares();
		
		
		frame.add(panel);
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				if((row + col) % 2 != 0)
				{
					this.model.getaSquare(row, col).getButton().setBackground(Settings.COLOR_BLACK);
				}
				if(set[row][col].getOccupierImage() != null)
				{
					ImageIcon temp = new ImageIcon(set[row][col].getOccupierImage());
					this.model.getaSquare(row, col).getButton().setIcon(temp);
				}
				panel.add(this.model.getaSquare(row, col).getButton());
			}
		}
	}
	
	@Override

	public void actionPerformed(ActionEvent e)
	{
		frame.repaint();
	}
	

}
