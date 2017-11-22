package edu.uwrf.segroup.model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View implements ActionListener {

	private JFrame frame;
	private Model model;
	
	@SuppressWarnings("serial")
	private class MyPanel extends JPanel {
	    
		public void paintComponent(Graphics g) {
			model.update(g);
        	revalidate();
        }
    }
	
	private MyPanel panel;
	
	View() {
		System.out.println("View()");	
	
		frame = new JFrame("MVC...BRAINS!!!");
		
		// Create a panel to contain sprites
		panel = new MyPanel();
		frame.add(panel);		

		frame.setSize(Settings.WIDTH, Settings.HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	} 
	
	public void addController(Controller controller){
		System.out.println("View      : adding controller");
		frame.getContentPane().addMouseListener(controller);
	}
	
	public void addModel(Model model){
		System.out.println("View      : adding model");
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
