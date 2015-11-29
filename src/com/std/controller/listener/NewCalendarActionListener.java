package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.std.controller.CalendarController;


/**
 * 
 * This class represents the listener for the new calendar
 * button.  It resets the calendar to a new one.
 * 
 * @author xxx
 *
 */
public class NewCalendarActionListener extends ControllerListener implements ActionListener {


	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public NewCalendarActionListener(CalendarController cc){
		super(cc);
	}
	
	/**
	 * This method resets the calendar to a 
	 * blank one.
	 * 
	 * @param ActionEvent e is the event
	 * spawn when the new calendar button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			getController().getModel().load(null);
		} catch(Exception ex) {
			getController().handleException(ex);
		}
	}

}



