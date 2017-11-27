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

public class Controller implements ActionListener
{
	
	Model model;
	View view;
	
	public Controller()
	{
		System.out.println("Controller()");
	}
	
	public void addModel(Model m)
	{
		System.out.println("Controller: adding model");
		this.model = m;
	}
	
	public void addView(View v)
	{
		System.out.println("Controller: adding view");
		this.view = v;
	}

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
						//System.out.println(model.getaSquare(row, col).getFlag());
						System.out.println(model.getaSquare(row, col).getOccupier().getClass().getSimpleName());
					}
					else
					{
						model.getaSquare(row, col).setFlag(true);
						//System.out.println(model.getaSquare(row, col).getFlag());
						System.out.println(model.getaSquare(row, col).getOccupier().getClass().getSimpleName());
					}
				}
			}
		}
	}

}
