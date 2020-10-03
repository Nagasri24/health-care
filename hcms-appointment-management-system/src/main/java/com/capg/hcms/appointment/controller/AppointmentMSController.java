package com.capg.hcms.appointment.controller;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.hcms.appointment.model.Appointment;
import com.capg.hcms.appointment.service.IAppointmentMSService;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     AppointmentMSController Class for accessing Appointment Management System services
*******************************************************************************************************************************/


@RestController
public class AppointmentMSController {

	@Autowired
	IAppointmentMSService service;

	@PostMapping("/appointment")
	public Appointment makeAppointment(@RequestBody Appointment appointment) {
		return service.makeAppointment(appointment);
	}
	
	@GetMapping("/getappointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable BigInteger appointmentId) {
		return service.getAppointment(appointmentId);
	}
	
	@GetMapping("/getallappointments")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointments();
	}
	
	@DeleteMapping("/removeappointment-centerid/{appointmentId}")
	public boolean removeAppointment(@PathVariable BigInteger appointmentId)
	{
		return  service.removeAppointmentById(appointmentId);
	}
}