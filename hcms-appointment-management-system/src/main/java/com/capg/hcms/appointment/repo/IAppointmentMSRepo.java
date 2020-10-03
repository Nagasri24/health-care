package com.capg.hcms.appointment.repo;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcms.appointment.model.Appointment;

/*******************************************************************************************************************************
-Author                   :     Nagasri
-Created/Modified Date    :     1-10-2020
-Description              :     AppointmentMsRepo interface acting as repository with Appointment class a type and BigInteger as ID
*******************************************************************************************************************************/


public interface IAppointmentMSRepo extends JpaRepository<Appointment, BigInteger> {
  
  public Appointment getAppointmentByDateTimeAndTestId(LocalDateTime dateTime,String testId);

 
  
}
