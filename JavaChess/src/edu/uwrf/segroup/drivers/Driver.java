package edu.uwrf.segroup.drivers;


import javax.swing.Timer;


import edu.uwrf.segroup.model.*;
//import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

/**
 * The Driver class used to run the program.
 * @author matta, charles
 */
public class Driver
{

	/**
	 * The main method of the Driver class which runs our program.
	 * @author matta, charles
	 */
	public static void main(String[] args)
	{
		
		Model model				= new Model(new OneBoardFactory());
		View view				= new View();
		Controller controller 	= new Controller();
		
		controller.addModel(model);
		controller.addView(view);
		
		view.addModel(model);
		view.addController(controller);
		
		new Timer(50, view).start();

	}

}
