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
import com.example.entity.Patient;
import com.example.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController 
{
	@Autowired
	private PatientService service;
	
	
	@PostMapping("/save")
	public String saveDoctors(@RequestBody Patient patient) 
	{
		return service.savePatient(patient);
	}
	
	@GetMapping("/get")
	public List<Patient> getDetails()
	{
		return service.getDetails();
	}
	
	@GetMapping("/getById/{id}")
	public Patient getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	
	@GetMapping("/doctorName/{id}")
	public ResponseTemplateVO getPatientWithDoctorName(@PathVariable int id)
	{
		return service.getPatientWithDoctorName(id);
	}
	
	@PutMapping("/update")
	public String updateDetails(@RequestBody Patient patient)
	{
		return service.updateDetails(patient);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDetails(@PathVariable int id)
	{
		return service.deleteDetails(id);
	}
	
}
