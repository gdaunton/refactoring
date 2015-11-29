package com.std.controller.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.std.controller.CalendarController;



/**
 * this is the action listener that is added to the load button
 * 
 * @author xxx
 * 
 */
public class OpenCalendarActionListener extends ControllerListener implements ActionListener {
	
	private class OpenRunnable implements Runnable {
		public void run() {
		    getController().open();
		}
	}


	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public OpenCalendarActionListener(CalendarController cc){
		super(cc);
	}
	
	public void actionPerformed(ActionEvent e) {
	    getController().confirm(new OpenRunnable());
	}
}
