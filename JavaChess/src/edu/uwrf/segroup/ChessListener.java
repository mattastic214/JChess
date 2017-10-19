package edu.uwrf.segroup;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessListener extends MouseAdapter {
	
	private boolean Activity;
	
	public ChessListener()
	{
		Activity = false;
	}
	
	public boolean getActivity()
	{
		return Activity;
	}
	
	public void setActivity(boolean Activity)
	{
		this.Activity = Activity;
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(Activity)
			Activity = false;
		else
			Activity = true;
		System.out.println(Activity);
	}

}
