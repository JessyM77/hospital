package com.example.VO;

import com.example.entity.Doctor;

public class ResponseTemplateVO 
{
	private Doctor doctor;
	private Patient patient;
	public ResponseTemplateVO() {
		super();
	}
	public ResponseTemplateVO(Doctor doctor, Patient patient) {
		super();
		this.doctor = doctor;
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "ResponseTemplateVO [doctor=" + doctor + ", patient=" + patient + "]";
	}
	
	
	
}
