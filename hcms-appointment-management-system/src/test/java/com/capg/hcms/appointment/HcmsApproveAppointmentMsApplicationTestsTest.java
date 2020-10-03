package com.capg.hcms.appointment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.appointment.controller.ApproveAppointmentController;
import com.capg.hcms.appointment.repo.IAppointmentMSRepo;
import com.capg.hcms.appointment.service.AppointmentMSServiceImpl;

@SpringBootTest(classes = HcmsAppointmentManagementSystemApplication.class)
class HcmsApproveAppointmentMsApplicationTestsTest {

	@Autowired
	AppointmentMSServiceImpl service;
	@Autowired
	IAppointmentMSRepo repo;
	@Autowired
	ApproveAppointmentController approveAppointment;

	@Test
	void testGetAllAppointments() {
		assertEquals(false, !repo.findAll().isEmpty());
	}

}

	

