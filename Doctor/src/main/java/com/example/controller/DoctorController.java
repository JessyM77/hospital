 package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VO.ResponseTemplateVO;
import com.example.entity.Doctor;
import com.example.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController 
{
	@Autowired
	private DoctorService service;
	
	@PostMapping("/save")
	public String saveDoctors(@RequestBody Doctor doctor)
	{
		return service.saveDoctors(doctor);
	}
	
	@GetMapping("/get")
	public List<Doctor> getDetails()
	{
		return service.getDetails();
	}
	
	@GetMapping("/getById/{id}")
	public Doctor getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	
	@GetMapping("/getByName/{name}")
	public List<Doctor> getByName(@PathVariable String name)
	{
		return  service.getByName(name);
	}
//	@GetMapping("/DoctorWithPatient/{id}")
//	public ResponseTemplateVO getDoctorWithPatient(@PathVariable int id)
//	{
//		return service.getDoctorWithPatient(id);
//	}
	
	@PutMapping("/update")
	public String updateDetails(@RequestBody Doctor doctor) {
		return service.updateDetails(doctor);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDetails(@PathVariable int id) {
		return service.deleteDetails(id);
	}
}
