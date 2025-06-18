package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Doctor.Doctor;


@Repository
public interface Dao extends JpaRepository<Doctor, Integer> {

	List<Doctor> findByName(String name);

	List<Doctor> findByExperience(int experience);

	List<Doctor> findByExperienceBetween(int min, int max);

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(d.specialization) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Doctor> searchByNameOrSpecialization(@Param("search") String search);

}
