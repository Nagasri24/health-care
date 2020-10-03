package com.capg.hcms.appointment.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcms.appointment.exception.AppointmentAlreadyApprovedException;
import com.capg.hcms.appointment.exception.AppointmentNotFoundException;
import com.capg.hcms.appointment.model.Appointment;
import com.capg.hcms.appointment.repo.IAppointmentMSRepo;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     AppointmentMSServiceImp Class implements services for Appointment Management System
*******************************************************************************************************************************/

@Service
public class AppointmentMSServiceImpl implements IAppointmentMSService {

	@Autowired
	IAppointmentMSRepo appointmentRepo;
	
	/*******************************************************************************************************************************
	-Function Name            :     makeAppointment
	-Input Parameters         :     Appointment Object
	-Return Type              :     appointment object
	-Author                   :     Nagasri
	-Created/Modified Date    :     1-10-2020
	-Description              :     adding appointment to the appointment database table 
	*******************************************************************************************************************************/
	
	@Override
	public Appointment makeAppointment(Appointment appointment) {
		
		appointment.setDateTime(LocalDateTime.now());
		Appointment app=appointmentRepo.save(appointment);
	    return app;
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getAppointment
	-Input Parameters         :     BigInteger appointmentId 
	-Return Type              :     Appointment Object
	-Throws                   :     AppointmentNotFoundException
	-Author                   :     Nagasri
	-Created/Modified Date    :     1-10-2020
	-Description              :     getting appointment based on appointmentId from appointment database table
	*******************************************************************************************************************************/


	@Override
	public Appointment getAppointment(BigInteger appointmentId) {

		if (!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id " + appointmentId + "not found");
		}
		return appointmentRepo.getOne(appointmentId);
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     getAllAppointments
	-Input Parameters         :     none
	-Return Type              :     appointment list
	-Throws                   :     AppointmentNotFoundException
	-Author                   :     Nagasri
	-Created/Modified Date    :     1-10-2020
	-Description              :     getting all the appointments from the appointment database table 
	*******************************************************************************************************************************/
    
	
	@Override
	public List<Appointment> getAllAppointments() {

		if (appointmentRepo.findAll().isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		List<Appointment> allAppointments = appointmentRepo.findAll();
		return allAppointments;
	}
	
	/*******************************************************************************************************************************
	-Function Name            :     approveAppointment
	-Input Parameters         :     Appointment Object and status boolean variable 
	-Return Type              :     appointment object
	-Throws                   :     AppointmentAlreadyApprovedException
	-Author                   :     Nagasri
	-Created/Modified Date    :     1-10-2020
	-Description              :     approves appointment and updates the appointment present in appointment database table 
	*******************************************************************************************************************************/

	@Override
	public Appointment approveAppointment(Appointment appointment, boolean status) {

		if (appointment.isApproved()) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
		}

		appointment.setApproved(status);
		return appointmentRepo.save(appointment);
	}

	/*******************************************************************************************************************************
	-Function Name            :     removeAppointmentById
	-Input Parameters         :     BigInteger appointmentId  
	-Return Type              :     boolean status
	-Throws                   :     AppointmentAlreadyApprovedException
	-Author                   :     Nagasri
	-Created/Modified Date    :     1-10-2020
	-Description              :     deletes appointment that is stored under listOfAppointments in a Diagnostic center
	*******************************************************************************************************************************/
    

	 @Override
		public boolean removeAppointmentById(BigInteger appointmentId) {
	    	
	    	if(!appointmentRepo.existsById(appointmentId)) {
	    		throw new AppointmentNotFoundException("Appointment with id: "+appointmentId+" not found");
	    	}
			appointmentRepo.deleteById(appointmentId);
			return true;
		}
	    
	}

