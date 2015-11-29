package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.std.controller.CalendarController;
import com.std.controller.dialog.AppointmentDialog;
import com.std.model.CalendarModelUtility;
import com.std.model.appointment.RefAppointment;

public class NewAppointmentActionListener extends ControllerListener implements ActionListener {

	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public NewAppointmentActionListener(CalendarController cc){
		super(cc);
	}
		
	/**
	 * This whent the user clicks the new appointent button, it creats
	 * a dialogue box that allows the user to enter new information
	 */
	
	public void actionPerformed(ActionEvent e) {
		RefAppointment ref = CalendarModelUtility.getNewAppointment(getController().getModel());
		
		if(AppointmentDialog.changeAppointment(getController().getView(), ref)) {
			CalendarModelUtility.addUsingPattern(getController().getModel(), ref);
		}
	}

}
