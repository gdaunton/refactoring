package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.std.controller.CalendarController;

/**
 * This is the listener listening to the exit menu item.
 * It should just dispose of the view, and let any handlers
 * kick in that need to.
 * 
 * @author xxx
 *
 */
public class ExitApplicationActionListener extends ControllerListener implements ActionListener {

	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public ExitApplicationActionListener(CalendarController cc){
		super(cc);
	}
	
	/**
	 * This occurs when the user has clicked the exit menu item.
	 * It should just dispose of the view, and let any handlers
	 * kick in that need to.
	 * 
	 * @param e is the action event, it is not used
	 */
	public void actionPerformed(ActionEvent e) {
		getController().getView().dispose();
	}
}
