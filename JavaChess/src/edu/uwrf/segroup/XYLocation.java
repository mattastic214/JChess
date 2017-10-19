package edu.uwrf.segroup;

import javax.swing.JLabel;

public class XYLocation {

	private int XLocation;
	private int YLocation;
	private JLabel Container;
	
	public XYLocation()
	{
		XLocation = 0;
		YLocation = 0;
		Container = new JLabel();
		Container.setLocation(XLocation, YLocation);
	}
	
	public int getXLocation()
	{
		return Container.getX();
	}
	
	public int getYLocation()
	{
		return Container.getY();
	}
	
	public JLabel getContainer()
	{
		return Container;
	}
	
	public void setXLocation(int XLocation)
	{
		Container.setLocation(XLocation, this.YLocation);
	}
	
	public void setYLocation(int YLocation)
	{
		Container.setLocation(this.XLocation, YLocation);
	}
	
	public void setLocation(int X, int Y)
	{
		Container.setLocation(X, Y);
	}
	
}
