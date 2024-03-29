package com.std.controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.std.controller.CalendarController;
import com.std.model.appointment.RefAppointment;

/**
 * This is the listener listening to the remove all appointment button
 * If the button is pressed the user will be promted if they are sure
 * they would like to delete the appointment, if it is a recurring appointment
 * then the user will be promted if they would like to remove all of the recurring 
 * appointments
 * 
 * @author xxx
 *
 */

public class RemoveAllAppointmentActionListener extends ControllerListener implements ActionListener {

	/**
	 * creates a new AppointmentSelectionMouseListener
	 * 
	 * @param CalendarControler cc is the reference to the controller 
	 */
	public RemoveAllAppointmentActionListener(CalendarController cc){
		super(cc);
	}
	
	/**
	 * This occurs when the user has clicked the remove all button, if a 
	 * Appointment is selected then the user is prompted if they are sure
	 * they would like to delete the appointment, if it is a recurring appointment
	 * then the user will be prompted if they would like to remove all of the recurring 
	 * appointments
	 * 
	 * @param e is the action event, it is not used
	 */
	public void actionPerformed(ActionEvent e) {
		RefAppointment ref = getController().getModel().getCurrentAppointment();
		if(ref != null)
		    getController().getModel().getAppointmentTemplateSet().remove(ref.getTemplate());
		else
			JOptionPane.showMessageDialog(getController().getView(), "no appointment is selected", "", JOptionPane.ERROR_MESSAGE);
	}
}
