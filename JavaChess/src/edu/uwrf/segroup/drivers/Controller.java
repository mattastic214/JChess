package edu.uwrf.segroup.drivers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import edu.uwrf.segroup.model.Model;
import edu.uwrf.segroup.model.Settings;

/**
 * The Controller class.
 */
public class Controller implements ActionListener
{
	
	Model model;
	View view;
	
	/**
	 * The Controller constructor
	 */
	public Controller()
	{
		System.out.println("Controller()");
	}
	
	/**
	 * Adds a Model argument to a controller object.
	 * @param m Model object.
	 */
	public void addModel(Model m)
	{

		System.out.println("Controller: adding model");
		this.model = m;
	}
	
	/**
	 * Adds a View argument to a controller object.
	 * @param v View object.
	 */
	public void addView(View v)
	{

		System.out.println("Controller: adding view");
		this.view = v;
	}
	
	// When a JButton/Square is pressed its flag is set to either true or false based on its
	// previous value.
	/**
	 * The actionPerformed method that overrides the ActionListener.
	 * @param arg0 ActionEvent object used to detect button Presses.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		System.out.println("A Button Is Pressed.");
		if(model.getaSquare(0, 0).getButton() == arg0.getSource())
			System.out.println("A Match!");
		for(int row = 0; row < Settings.NUM_ROWS; row++)
		{
			for(int col = 0; col < Settings.NUM_COLS; col++)
			{
				if(model.getaSquare(row, col).getButton() == arg0.getSource())
				{
					if(model.getaSquare(row, col).getFlag() == true)
					{
						model.getaSquare(row, col).setFlag(false);
						System.out.println(model.getaSquare(row, col).getFlag());
						//System.out.println(model.getaSquare(row, col).getOccupier().getClass().getSimpleName());
					}
					else
					{
						model.getaSquare(row, col).setFlag(true);
						System.out.println(model.getaSquare(row, col).getFlag());
						//System.out.println(model.getaSquare(row, col).getOccupier().getClass().getSimpleName());
					}
				}
			}
		}

	}

}
