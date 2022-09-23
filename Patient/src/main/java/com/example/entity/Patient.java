package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	private String visitedDoctorName;
	private String dateOfVisit;
	private String prescription;
	private int dId;
	public Patient() {
		super();
	}
	public Patient(int id, String name, int age, String visitedDoctorName, String dateOfVisit, String prescription, int dId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.visitedDoctorName = visitedDoctorName;
		this.dateOfVisit = dateOfVisit;
		this.prescription = prescription;
		this.dId = dId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVisitedDoctorName() {
		return visitedDoctorName;
	}
	public void setVisitedDoctorName(String visitedDoctorName) {
		this.visitedDoctorName = visitedDoctorName;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", visitedDoctorName=" + visitedDoctorName
				+ ", dateOfVisit=" + dateOfVisit + ", prescription=" + prescription + ", dId=" + dId + "]";
	}

	
}
