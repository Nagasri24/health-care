package com.capg.hcms.appointment.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.hcms.appointment.model.Appointment;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020 
-Description              :     IAppointmentMSService Interface with services for Appointment Management System
*******************************************************************************************************************************/



public interface IAppointmentMSService {

	Appointment makeAppointment(Appointment appointment);
    Appointment getAppointment(BigInteger appointmentId);
	List<Appointment> getAllAppointments();
	Appointment approveAppointment(Appointment appointment,boolean status);
	boolean removeAppointmentById(BigInteger appointmentId);
	
}