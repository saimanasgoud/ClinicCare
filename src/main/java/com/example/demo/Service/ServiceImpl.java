package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Repository.Dao;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	private Dao dao;
 
	@Override
	public Doctor save(Doctor doctor) {
		return dao.save(doctor);
	}

	@Override
	public List<Doctor> saveAll(List<Doctor> doctor) {
		return dao.saveAll(doctor);
	}

	@Override
	public List<Doctor> findAll() {
		return dao.findAll();
	}

	@Override
	public Doctor findById(int id) {
		Optional<Doctor> optional = dao.findById(id);
		if(optional.isPresent()) {
//			Doctor doctor = optional.get();
			return optional.get(); 
		}
		else {
			return null;
		}
	}

	@Override
	public List<Doctor> sortById() {
		return dao.findAll(Sort.by("id").descending()) ;
	}

	@Override
	public String delete(int id) {	
		Optional<Doctor> optional = dao.findById(id);
		if(optional.isPresent()) {
			Doctor doctor = optional.get();
			dao.deleteById(id);
			return "DOCTOR WITH ID " + id + " DELETED SUCCESSFUL \n" + doctor;
		}
		else {
			return "DOCTOR WITH ID " + id + " NOT FOUND OR IT HAS BEEN DELEATED ";
		}	
	}
	
	@Override
	public String update(int id, Doctor new_doctor) {
		Optional<Doctor> optional = dao.findById(id);
		if(optional.isPresent()) {
			Doctor old_doctor = optional.get();
			old_doctor.setName(new_doctor.getName());
			old_doctor.setLocation(new_doctor.getLocation());
			old_doctor.setTime(new_doctor.getTime());
			old_doctor.setExperience(new_doctor.getExperience());
	        old_doctor.setSpecialization(new_doctor.getSpecialization());
	        old_doctor.setGender(new_doctor.getGender());
	        old_doctor.setAvalableDays(new_doctor.getAvalableDays());
			dao.save(old_doctor);
			return "DOCTOR WITH ID " + id +  " UPDATED SUCCESSFUL";
		}
		else {
			return "DOCTOR WITH ID " + id + " NOT FOUND TO UPDATE" ;	
		}
	}
	
	@Override
	public List<Doctor> mypagination() {	
		PageRequest pagerequest = PageRequest.of(0, 2);
		Page<Doctor> page = dao.findAll(pagerequest);
		return page.toList();
	}

	//In Java, isPresent() is only used with Optional<T>, not with a List<T>. Since dao.findAll() returns a List<Doctor>, you cannot use isPresent() directly.
	//However, if you're insisting on using Optional, you can wrap the list yourself like this:
	
	@Override 
	public String deleteAll() {
		List<Doctor> optional = dao.findAll();
		if(optional.isEmpty()) {
			return "THERE IS NO RECORDS FOUND TO DELETE ";
		}
		else {
			dao.deleteAll();
			return "ALL RECORDS HAVE BEEN DELEATED SUCCESSFUL...";
		}
	}

	@Override
	public List<Doctor> updateAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Doctor> findByExperience(int experience) {
	    return dao.findByExperience(experience);
	}

	@Override
	public List<Doctor> findByExperienceRange(int minExp, int maxExp) {

		return dao.findByExperienceBetween(minExp, maxExp);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public List<Doctor> searchByNameOrSpecialization(String search) {
	    return dao.searchByNameOrSpecialization(search);
	}


}	

