package edu.uwrf.segroup.model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {
	
	Model model;
	View view;
	
	public Controller() {
		System.out.println("Controller()");
	}
	
	public void addMode(Model m) {
		System.out.println("Controller: adding model");
		this.model = m;
	}
	
	public void addView(View v) {
		System.out.println("Controller: adding view");
		this.view = v;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
