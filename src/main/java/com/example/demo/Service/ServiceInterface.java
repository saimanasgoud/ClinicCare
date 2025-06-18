package com.example.demo.Service;

import java.util.List;

import com.example.demo.Doctor.Doctor;

public interface ServiceInterface {

	Doctor save(Doctor doctor);

	List<Doctor> saveAll(List<Doctor> doctor);

	List<Doctor> findAll();

	Doctor findById(int id);

	List<Doctor> sortById();

	String delete(int id);

	String update(int id, Doctor doctor);

	List<Doctor> mypagination();

	String deleteAll();

	List<Doctor> updateAll();

	List<Doctor> findByName(String name);

	List<Doctor> findByExperience(int experience);

	List<Doctor> findByExperienceRange(int minExp, int maxExp);

	List<Doctor> getAllDoctors();

	List<Doctor> searchByNameOrSpecialization(String search);

}
