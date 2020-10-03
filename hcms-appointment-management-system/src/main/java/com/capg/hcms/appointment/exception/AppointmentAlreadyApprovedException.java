package com.capg.hcms.appointment.exception;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :    1-10-2020
-Description              :     AppointmentAlreadyApprovedException class to handle runtime exception
*******************************************************************************************************************************/


public class AppointmentAlreadyApprovedException extends RuntimeException {

	public AppointmentAlreadyApprovedException(String message)
	{
		super(message);
	}
}
