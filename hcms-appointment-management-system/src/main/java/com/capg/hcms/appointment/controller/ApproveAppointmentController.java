package com.capg.hcms.appointment.controller;

import java.math.BigInteger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcms.appointment.model.Appointment;
import com.capg.hcms.appointment.service.IAppointmentMSService;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     ApproveAppointmentController Class for accessing Appointment Management System services
*******************************************************************************************************************************/


@RestController
@RequestMapping("/admin")
public class ApproveAppointmentController {

	@Autowired
	IAppointmentMSService service;

	@GetMapping("/getAppointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable BigInteger appointmentId) {
		return service.getAppointment(appointmentId);
	}

	@GetMapping("/getallappointments")
	public List<Appointment> getAllAppointment() {
		return service.getAllAppointments();
	}

	@PutMapping("/approveAppointment/{appointmentId}/status/{status}")
	public Appointment approveAppoinment(@PathVariable BigInteger appointmentId, @PathVariable boolean status) {
		Appointment appointment = service.getAppointment(appointmentId);
		return service.approveAppointment(appointment, status);
	}

}