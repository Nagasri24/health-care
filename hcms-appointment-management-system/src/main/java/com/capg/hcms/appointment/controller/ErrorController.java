package com.capg.hcms.appointment.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.hcms.appointment.exception.AppointmentAlreadyApprovedException;
import com.capg.hcms.appointment.exception.AppointmentNotFoundException;
import com.capg.hcms.appointment.exception.ErrorInfo;



/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     ErrorController Class for handling Appointment Management System Exceptions
*******************************************************************************************************************************/


@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(value= {AppointmentAlreadyApprovedException.class})
	public ErrorInfo handleAppointmentAlreadyApproved(AppointmentAlreadyApprovedException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}

	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {AppointmentNotFoundException.class})
	public ErrorInfo AppointmentNotFound(AppointmentNotFoundException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	
}