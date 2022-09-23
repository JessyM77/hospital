package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;


@SpringBootTest
class DoctorApplicationTests 
{
	@Autowired
	DoctorRepository repo;
	
	@Test
	public void TestCreate() throws Exception
	{
		Doctor d = new Doctor();
		d.setId(20);
		d.setName("Hellen");
		d.setGender("Female");
		d.setAge(34);
		d.setNo_Of_Patients(20);
		d.setSpecialist("Surgeon");
		repo.save(d);
		
	}

}
