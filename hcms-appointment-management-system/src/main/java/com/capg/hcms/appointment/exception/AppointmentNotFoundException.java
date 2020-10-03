package com.capg.hcms.appointment.exception;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     AppointmentNotFoundException class to handle runtime exception
*******************************************************************************************************************************/


public class AppointmentNotFoundException extends RuntimeException {


	public AppointmentNotFoundException(String message) {
		super(message);
	}

	
}
