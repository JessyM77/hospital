package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.VO.Doctor;
import com.example.VO.ResponseTemplateVO;
import com.example.entity.Patient;
import com.example.repository.PatientRepository;

@Service
public class PatientService 
{
	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String savePatient(Patient patient)
	{
		repository.save(patient);
		return "Patient Details saved successfully";
	}
	
	public List<Patient> getDetails()
	{
		return repository.findAll();
	}
	
	public Patient getById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public String deleteDetails(int id)
	{
		repository.deleteById(id);
		return "Deleted Successfully";
	}
	
	public String updateDetails(Patient patient)
	{
		Patient existing = repository.findById(patient.getId()).orElse(null);
		
		existing.setName(patient.getName());
		existing.setAge(patient.getAge());
		existing.setVisitedDoctorName(patient.getVisitedDoctorName());
		existing.setDateOfVisit(patient.getDateOfVisit());
		existing.setPrescription(patient.getPrescription());
		existing.setdId(patient.getdId());
		
		repository.save(existing);
		return "Updated Successfully";
		
	}

	public ResponseTemplateVO getPatientWithDoctorName(int id) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Patient patient = repository.findById(id).orElse(null);
		
		Doctor doctor = restTemplate.getForObject("http://DOCTOR/doctor/getById/" + patient.getdId(), Doctor.class);
		
		vo.setDoctor(doctor);
		vo.setPatient(patient);
		patient.setVisitedDoctorName(doctor.getName());
		return vo;
	}
}
