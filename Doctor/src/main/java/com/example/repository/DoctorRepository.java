package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>
{
	List<Doctor> findByName(String name);
	Doctor findById(int id);
}
