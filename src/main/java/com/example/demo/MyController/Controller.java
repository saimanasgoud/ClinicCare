package com.example.demo.MyController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Doctor.Doctor;
import com.example.demo.Service.ServiceInterface;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:5173") 
public class Controller {
	
	@Autowired
	private ServiceInterface service;
		
	@PostMapping("/")
	public Doctor save(@RequestBody Doctor doctor) {
		return service.save(doctor);
	}
	
	@PostMapping("/saveall")
	public List<Doctor> saveAll(@RequestBody List<Doctor> doctor){
		return service.saveAll(doctor);
	}
//	
//	@GetMapping
//	public List<Doctor> searchDoctors(@RequestParam(required = false) String search) {
//	    if (search == null || search.trim().isEmpty()) {
//	        return service.getAllDoctors();
//	    } else {
//	        return service.searchByNameOrSpecialization(search);
//	    }
//	}
	
//	@GetMapping("/")
//	public List<Doctor> findAll() {
//		return service.findAll();
//	}
	
	@GetMapping
	public List<Doctor> SearchDoctors(@RequestParam(required = false) String search) {
	    System.out.println("Search term received: " + search); // Log search term
		if (search == null || search.trim().isEmpty()) {
	        return service.findAll();
	    } else {
	        return service.searchByNameOrSpecialization(search); // Filtered
	    }
	}

	@GetMapping("/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable int id) {
	    Doctor doctor = service.findById(id);
	    if (doctor == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	    return ResponseEntity.ok(doctor);
	}
	
//	@GetMapping("/{id}")
//	public Doctor findById(@PathVariable int id) {
//		return service.findById(id);
//	}
	
	//sorting by id
	@GetMapping("/descsort")
	public List<Doctor> sortById(){
		return service.sortById();
	}
	//delete by id
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	//update the record by using id
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody Doctor doctor) {
		return service.update(id, doctor);
	}
	
	@GetMapping("/pagination")
	public List<Doctor> myPagination(){
		return service.mypagination();
	}
	
	//delete all records
	@DeleteMapping("/deleteall")
	public String deletell() {
		return service.deleteAll();
	}
	
	@GetMapping("/find/{name}")
	public List<Doctor> findByName(@PathVariable String name) {
		return service.findByName(name);
	}
	
	@GetMapping("/exp/{experience}")
	public List<Doctor> findByExperience(@PathVariable int experience){
		return service.findByExperience(experience);
	}
	
	//By using between oparator
	@GetMapping("/exp")
	public List<Doctor> findByExperienceRange(@RequestParam int minExp, @RequestParam int maxExp) {
    return service.findByExperienceRange(minExp, maxExp);
	}
	
	@PutMapping("/new")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
	    return service.save(doctor); // assumes save() handles both insert & update
	}

}
