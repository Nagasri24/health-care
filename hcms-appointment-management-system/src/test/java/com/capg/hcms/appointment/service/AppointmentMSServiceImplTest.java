package com.capg.hcms.appointment.service;


import static org.junit.jupiter.api.Assertions.assertThrows;


import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.hcms.appointment.HcmsAppointmentManagementSystemApplication;
import com.capg.hcms.appointment.exception.AppointmentNotFoundException;
import com.capg.hcms.appointment.model.Appointment;


@SpringBootTest(classes = HcmsAppointmentManagementSystemApplication.class)
class AppointmentMSServiceImplTest {

	@Autowired
	IAppointmentMSService service;
	
	Appointment appointment;
	Appointment appointment1;
	Appointment appointment2;
	

	
	@BeforeEach
	public void setUp() {

		appointment = new Appointment("120", BigInteger.valueOf(0), "23", LocalDateTime.of(2020, 6, 20, 9, 30), false);
		appointment1=new Appointment("230", BigInteger.valueOf(0), "12", LocalDateTime.of(2020, 5, 9, 9, 30), false);
		appointment2=new Appointment("230", BigInteger.valueOf(0) , "12", LocalDateTime.of(2020,9 , 9, 11, 30), false);
	}


	@Test
	public void testAppointmentNotFoundException() {
		assertThrows(AppointmentNotFoundException.class, () -> {
			service.getAppointment(BigInteger.valueOf(50));
		});
	}

}
