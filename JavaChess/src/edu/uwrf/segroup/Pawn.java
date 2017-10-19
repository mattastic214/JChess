package edu.uwrf.segroup;

import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Pawn extends ChessPiece {
	
	private URL ImageSource;
	private ImageIcon Image;
	
	public Pawn()
	{
		super();
		ImageSource = Pawn.class.getResource("/resources/pawn.png");
		Image = new ImageIcon(ImageSource);
		super.setContainer(Image);
	}

}
