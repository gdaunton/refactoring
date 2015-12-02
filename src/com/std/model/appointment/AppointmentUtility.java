package com.std.model.appointment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.std.model.pattern.RecurrencePattern;
import com.std.util.range.DateRange;

/**
 * AppointmentUtility is a utility class for working with Appointments
 * 
 * @author xxx
 */
public class AppointmentUtility {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("EEE, d MMM yyyy 'at' h:mm aa");
	
	public static final String NO_RECUR = "does not recur";
	
	/**
	 * Returns a sorted set of the appointments in set that 
	 * are at least partially contained by range
	 * 
	 * @param set set of all appointments
	 * @param range range to bound by
	 * @return a sorted set of the appointments in set that 
	 * are at least partially contained by range
	 */
	public static SortedSet<RefAppointment> getRange(Set<RefAppointment> set, DateRange range) {
		if(set == null)
			throw new NullPointerException("set");
		if(range == null)
			throw new NullPointerException("range");
		
		TreeSet<RefAppointment> startSet = new TreeSet<RefAppointment>(RefAppointment.COMPARATOR_APPOINTMENT_START);
		startSet.addAll(set);
		
		TreeSet<RefAppointment> endSet = new TreeSet<RefAppointment>(RefAppointment.COMPARATOR_APPOINTMENT_END);
		endSet.addAll(set);
		
		AppointmentTemplate apptTmpl = new AppointmentTemplate("", "", "", 0);
		RefAppointment startAppt = new RefAppointment(range.getStartDate(), apptTmpl);
		RefAppointment endAppt = new RefAppointment(range.getEndDate(), apptTmpl);
		
		SortedSet<RefAppointment> ret = startSet.headSet(endAppt);
		ret.removeAll(endSet.headSet(startAppt));
		
		return ret;
	}
	
	/**
	 * Returns a set of all the associated RefAppointments of a 
	 * AppointmentTemplate according to its RecurrencePattern
	 * 
	 * @param apptTmpl AppointmentTemplate to generate the pattern references of
	 * @return a set of all the associated RefAppointments of a 
	 * AppointmentTemplate according to its RecurrencePattern
	 */
	public static Set<RefAppointment> generatePatternAppointments(AppointmentTemplate apptTmpl) {
		if(apptTmpl == null)
			throw new NullPointerException("set");
		
		Set<RefAppointment> ret = new HashSet<RefAppointment>();
		if(apptTmpl.getPattern() != null)
			for(Date date : apptTmpl.getPattern().getDates())
				ret.add(new RefAppointment(date, apptTmpl));
		
		return ret;
	}
	
	public static String getPatternDescription(RecurrencePattern pattern) {
		if(pattern != null) {
			String text = pattern.getDescription();
			if (text.length() > 0)
				return text + " from " + FORMAT.format(pattern.getRange().getStartDate())
					+ " to " + FORMAT.format(pattern.getRange().getEndDate());
			else
				return NO_RECUR;
		}
		return NO_RECUR;
	}
	
	public static String getDurationDescription(long ms) {
		
		// construct the base conversions
		long min = ms / 1000 / 60;
		long hours = min / 60;
		long days = hours / 24;
		long weeks = days / 7;
		
		// truncate the conversions to get categories
		days %= 7;
		hours %= 24;
		min %= 60;
		
		// construct the string
		String s = "";
		if(weeks != 0)
			s += weeks + " week(s), ";
		if(days != 0)
			s += days + " day(s), ";
		if(hours != 0)
			s += hours + " hour(s), ";
		if(min != 0)
			s += min + " minute(s), ";
		if(s.length() == 0)
			s = "instantaneous";
		else
			s = s.substring(0, s.length()-2);
		
		// set the text
		return s;
	}
}
