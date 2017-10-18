package edu.uwrf.segroup;


public  abstract class ChessPiece {


	private XYLocation XYLocation;
	private boolean Enabler;
	private int Sider;
	
	public ChessPiece()
	{
		this.XYLocation = new XYLocation();
		Enabler = false;
		Sider = 0;
	}
	
	public int getXLocation()
	{
		return this.XYLocation.getXLocation();
	}
	
	public int getYLocation()
	{
		return this.XYLocation.getYLocation();
	}
	
	public boolean getEnabler()
	{
		return Enabler;
	}
	
	public int getSider()
	{
		return Sider;
	}
	
	public void setXLocation(int XLocation)
	{
		this.XYLocation.setXLocation(XLocation);
	}
	
	public void setYLocation(int YLocation)
	{
		this.XYLocation.setYLocation(YLocation);
	}
	
	public void setEnabler(boolean Enabler)
	{
		this.Enabler = Enabler;
	}
	
	public void setSider(int Sider)
	{
		this.Sider = Sider;
	}
	
}
