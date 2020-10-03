package com.capg.hcms.appointment.model;

import java.util.List;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     AppointmentList Bean Class for appointmentList property
*******************************************************************************************************************************/

public class AppointmentList {

	private List<Appointment> appointmentsList;

	public AppointmentList() {
		super();
	}

	public AppointmentList(List<Appointment> appointmentsList) {
		super();
		this.appointmentsList = appointmentsList;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentsList;
	}

	public void setAppointmentList(List<Appointment> appointmentsList) {
		this.appointmentsList = appointmentsList;
	}

	@Override
	public String toString() {
		return "AppointmentList [appointmentsList=" + appointmentsList + "]";
	}
	
	
}