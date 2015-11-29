package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.std.controller.CalendarController;
import com.std.model.CalendarModelUtility;

/**
 * This class serves as the Action Listener for the next
 * button in the view.  it is instantiated in CalendarControler and sent
 * to the CalendarView.  
 * @author xxx
 */
public class NextButtonActionListener extends ControllerListener implements ActionListener {


	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public NextButtonActionListener(CalendarController cc){
		super(cc);
	}
	
	/**
	 * 
	 * This method changes the current date in the model based on the current
	 * state of the MainView (aka: based on which panel: monthly, weekly, or daily,
	 * is being displayed in MainView).
	 * 
	 *@param ActionEvent e is the ActionEvent passed when the next
	 *button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		
		switch(getController().getView().getTabbedState()) {
		
		case MONTHLY:
			CalendarModelUtility.nextMonth(getController().getModel());
			break;
			
		case WEEKLY:
			CalendarModelUtility.nextWeek(getController().getModel());
			break;
			
		case DAILY:
			CalendarModelUtility.nextDay(getController().getModel());
		}
	}
}
