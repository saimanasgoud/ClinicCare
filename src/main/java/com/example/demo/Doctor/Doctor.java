package com.example.demo.Doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Doctor {
	
	@Id
	@Column
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Integer 
	int id;
	int experience;
	String name;
	String specialization;
	String location;
	String gender;
	String time;
	String avalableDays;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAvalableDays() {
		return avalableDays;
	}
	public void setAvalableDays(String avalableDays) {
		this.avalableDays = avalableDays;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", experience=" + experience + ", name=" + name + ", specialization="
				+ specialization + ", location=" + location + ", gender=" + gender + ", time=" + time
				+ ", avalableDays=" + avalableDays + "]";
	}
	
	
}
