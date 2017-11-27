package edu.uwrf.segroup;

import javax.swing.*;

public abstract class ChessPiece {

	//private XYLocation XYLocation;
	private boolean Enabler;
	private boolean Activity;
	private JLabel Container;
	private int Sider;
	
	public ChessPiece()
	{
		//this.XYLocation = new XYLocation();
		Enabler = false;
		Activity = false;
		Container = new JLabel();
		Sider = 0;
	}
	/*
	public int getXLocation()
	{
		return this.XYLocation.getXLocation();
	}
	
	public int getYLocation()
	{
		return this.XYLocation.getYLocation();
	}
	*/
	public boolean getEnabler()
	{
		return Enabler;
	}
	
	public boolean getActivity()
	{
		return Activity;
	}
	
	public JLabel getContainer()
	{
		return Container;
	}
	
	public int getSider()
	{
		return Sider;
	}
	/*
	public void setXLocation(int XLocation)
	{
		this.XYLocation.setXLocation(XLocation);
	}
	
	public void setYLocation(int YLocation)
	{
		this.XYLocation.setYLocation(YLocation);
	}
	*/
	public void setEnabler(boolean Enabler)
	{
		this.Enabler = Enabler;
	}
	
	public void setActivity(boolean Activity)
	{
		this.Activity = Activity;
	}
	
	public void setContainer(Icon Image)
	{
		this.Container.setIcon(Image);
	}
	
	public void setSider(int Sider)
	{
		this.Sider = Sider;
	}
	
	public abstract void move();
	
	
}
