package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.VO.Patient;
import com.example.VO.ResponseTemplateVO;
import com.example.entity.Doctor;
import com.example.repository.DoctorRepository;

@Service
public class DoctorService 
{
	@Autowired
	private DoctorRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public String saveDoctors(Doctor doctor)
	{
		repository.save(doctor);
		return "Doctor Details saved successfully";
	}
	
	public List<Doctor> getDetails()
	{
		return repository.findAll();
	}
	
	public List<Doctor> getByName(String name)
	{
		return  repository.findByName(name);
	}
	
	public Doctor getById(int id)
	{
		return repository.findById(id);
	}
	
	public String updateDetails(Doctor doctor)
	{
		Doctor existing = repository.findById(doctor.getId());
		
		existing.setName(doctor.getName());
		existing.setGender(doctor.getGender());
		existing.setAge(doctor.getAge());
		existing.setSpecialist(doctor.getSpecialist());
		existing.setNo_Of_Patients(doctor.getNo_Of_Patients());
		
		repository.save(existing);
		return "Updated Successfully";
		
	}
	
	public String deleteDetails(int id)
	{
		repository.deleteById(id);
		return "Deleted Successfully";
	}

//	public ResponseTemplateVO getDoctorWithPatient(int id) 
//	{
//		ResponseTemplateVO vo = new ResponseTemplateVO();
//		Doctor doctor = repository.findById(id);
//		
//		Patient patient = restTemplate.getForObject("http://localhost:9091/patient/getById/" + doctor.getpId(), Patient.class);
//		
//		vo.setDoctor(doctor);
//		vo.setPatient(patient);
//		
//		return vo;
//	}
	
}
