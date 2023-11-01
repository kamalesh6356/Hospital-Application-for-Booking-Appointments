package com.example.doctor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tech.stl.doctor.entity.Doctor;
import tech.stl.doctor.repository.DoctorRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

class DoctorApplicationTests {
	@Autowired
	private DoctorRepository docrepo;
	
	@Test
	@Order(1)
	public void testCreate() {
		Doctor doc=new Doctor();
		doc.setAppointmentId(5L);
		doc.setName("dr kumar");
		doc.setSpecialisation("Medical Oncology");
		docrepo.save(doc);
		assertNotNull(docrepo.findById(5L));
		
	}
	@Test
    @Order(2)
    public void ReadlAll(){
		List<Doctor> list=docrepo.findAll();   
	  	assertThat(list).size().isGreaterThan(0);
	}
	@Test
    @Order(3)
	public void TestSingleDoctor()
	{
		Doctor doc=docrepo.findById(5L).get();
		assertEquals("dr kumar", doc.getName());
	}
	@Test
    @Order(4)
	public void updateTest()
	{
		Doctor doc=docrepo.findById(5L).get();
		doc.setSpecialisation("surgical");
        docrepo.save(doc);
          assertNotNull("Medical Oncology",docrepo.findById(5L).get().getSpecialisation());
	}
	@Test
    @Order(5)
	public void deleteTest()
	{
		docrepo.deleteById(5L);
		assertThat(docrepo.existsById(5L)).isFalse();
		
		
	}


}
