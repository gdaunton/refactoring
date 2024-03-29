package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import com.std.controller.CalendarController;
import com.std.view.block.DayBlock;


/**
 * This class serves as the listener of each day in the view panels.
 * 
 * @author xxx
 *
 */
public class DateSelectionActionListener extends ControllerListener implements ActionListener {
	

	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public DateSelectionActionListener(CalendarController cc){
		super(cc);
	}

	/**
	 * This method is called whenever the user clicks a day in the view.
	 * This method then updates the currentDate in the model.
	 * 
	 * @param ActionEvent e is the event sent when the day in the panel is clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		//get the day block that this listener was listening too
		DayBlock db = (DayBlock) e.getSource();
		Date newSelectedDate = db.getDate();
		getController().getModel().setCurrentDate(newSelectedDate);
	}

}
