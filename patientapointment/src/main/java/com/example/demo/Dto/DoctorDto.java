package com.example.demo.Dto;

import com.example.demo.model.Specialization;

public class DoctorDto {
	
	private Long doctorId;
	private String name;
	private Specialization specialization;
	
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	
}
