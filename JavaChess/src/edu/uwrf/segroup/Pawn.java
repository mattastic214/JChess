package edu.uwrf.segroup;

import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Pawn extends ChessPiece implements MouseListener {
	
	private URL ImageSource;
	private ImageIcon Image;
	
	public Pawn()
	{
		super();
		ImageSource = Pawn.class.getResource("/resources/pawn.png");
		Image = new ImageIcon(ImageSource);
		super.setContainer(Image);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
