package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.std.controller.CalendarController;

public class SaveAsCalendarActionListener extends ControllerListener implements ActionListener {


	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public SaveAsCalendarActionListener(CalendarController cc){
		super(cc);
	}
	 /** This allows the user to save a calendar when they 
	 * 	click the saveAs  button.
	 * 
	 * 	@param ActionEvent e is the event sent to this method when
	 * 	the user pressed the saveAs button.
	 */
	public void actionPerformed(ActionEvent e) {
	    getController().saveAs();
	}

}
