package edu.uwrf.segroup.model;

import edu.uwrf.segroup.model.exceptions.FriendlyCollisionException;

public class Driver {

	public static void main(String[] args) throws FriendlyCollisionException {
		
		Model model				= new Model(new OneBoardFactory());
		View view				= new View();
		Controller controller 	= new Controller();
		
		controller.addModel(model);
		controller.addView(view);
		
		view.addModel(model);
		view.addController(controller);

	}

}
