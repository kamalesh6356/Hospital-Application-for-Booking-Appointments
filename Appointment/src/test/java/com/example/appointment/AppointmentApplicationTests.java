package com.example.appointment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import antlr.collections.List;
import tech.stl.appointments.entity.Appointment;
import tech.stl.appointments.repository.AppointmentRepository;

@SpringBootTest
class AppointmentApplicationTests {


	    
	    
	    @Autowired
	    AppointmentRepository appRepo;
	    
	    @Test
	    public void testCreate() {
	        Appointment a = new Appointment();
//	        a.setId(3L);
	        a.setAppointmentDate("28/05/2022");
	        a.setPatientName("online");
//	        a.setDoctorId(3L);
	        appRepo.save(a);
	        assertNotNull(appRepo.findById(1L).get());;
	    }
	    


	    @Test
	    public void testOneAppointment()
	    {
	        Appointment app=  appRepo.findById(1L).get();
	        assertEquals("28/05/2022",app.getAppointmentDate());
	    }
	    
	    @Test
	    public void testUpdate()
	    {
	        Appointment a = appRepo.findById(1L).get();
	        a.setAppointmentDate("28/05/2022");;
	        appRepo.save(a);
	        assertNotEquals("28/05/2022", appRepo.findById(1L).get().getAppointmentDate());
	    }
	    
	    @Test
	    public void testDelete() 
	    {
	        appRepo.deleteById(1L);
	        assertThat(appRepo.existsById(1L)).isFalse();
	    }
	    
	    

}
