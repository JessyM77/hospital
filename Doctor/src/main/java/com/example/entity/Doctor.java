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
public class Doctor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	private int age;
	private String specialist;
	private int no_Of_Patients;
	public Doctor() {
		super();
	}
	public Doctor(int id, String name, String specialist, int no_Of_Patients) {
		super();
		this.id = id;
		this.name = name;
		this.specialist = specialist;
		this.no_Of_Patients = no_Of_Patients;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	
	public int getNo_Of_Patients() {
		return no_Of_Patients;
	}
	public void setNo_Of_Patients(int no_Of_Patients) {
		this.no_Of_Patients = no_Of_Patients;
	}
	
	
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", specialist="
				+ specialist + ", no_Of_Patients=" + no_Of_Patients + "]";
	}
	
	

}
