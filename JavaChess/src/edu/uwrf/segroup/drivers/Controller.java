package edu.uwrf.segroup.drivers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

import edu.uwrf.segroup.model.Model;

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
	}

}
