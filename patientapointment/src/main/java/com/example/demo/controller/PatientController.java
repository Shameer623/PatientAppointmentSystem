package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dto.PatientDto;
import com.example.demo.service.PatientService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("patients")
//head of the request url
public class PatientController {
@Autowired 
//link the patient controller and patient service 
private PatientService patientservice;

//patient can register their details first
@PostMapping("/register")
public String registerPatient(@RequestBody PatientDto patientDto) {

	return patientservice.registerPatient(patientDto);
}

//patient can delete the registration they want
@DeleteMapping("/{id}")
public ResponseEntity<String>deletePatient(@PathVariable  long id){
	String response=patientservice.deletePatientById(id);
	return ResponseEntity.ok(response);
}
}
