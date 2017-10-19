package edu.uwrf.segroup;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Square {

	private JLabel Container;
	
	public Square()
	{
		//super(); Extends Shape
		Container = new JLabel();
	}
	
	public JLabel getContainer()
	{
		return Container;
	}

}
