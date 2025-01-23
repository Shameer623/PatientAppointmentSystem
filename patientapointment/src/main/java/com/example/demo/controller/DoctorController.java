package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dto.DoctorDto;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;


@RestController
@RequestMapping("doctors")
public class DoctorController {
@Autowired
private DoctorService doctorService;

@PostMapping("/add")
public String addDoctor(@RequestBody DoctorDto doctorDto) {
	return doctorService.addDoctor(doctorDto);

	
}

@GetMapping("/get/doctor/{doctorId}")
public Doctor getDoctorById(@PathVariable Long doctorId) {
	return doctorService.getDoctorById(doctorId);

}

@DeleteMapping("/delete/doctor/{doctorId}")
public String delteDoctor(@PathVariable Long doctorId) {
	return doctorService.deleteDoctor(doctorId);
}


@PutMapping("/update") 
public ResponseEntity<String> updateDoctor(@RequestBody DoctorDto doctorDto)
{
	String response = doctorService.updateDoctor(doctorDto);
if ("Doctor updated successfully".equals(response)) { 
	return ResponseEntity.ok(response);
	}
else { 
	return ResponseEntity.status(404).body(response);
	}
}
}

