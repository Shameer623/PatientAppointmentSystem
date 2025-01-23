package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.PatientDto;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
@Autowired
private PatientRepository patientRepository;

//get all patient registration list for the admin
public List<Patient> getAllPatients(){
	return patientRepository.findAll();
}
//patient can register for this bussines logic implementation
 public String  registerPatient(PatientDto patientDto) {
	 Patient tst = patientRepository.findByFirstname(patientDto.getFirstname()).orElse(null);

	 if(tst!=null) {
		return "user alredy exists";
	}
	Patient patient=new Patient();
	patient.setFirstname(patientDto.getFirstname());
	patient.setLastname(patientDto.getLastname());
	patient.setContact(patientDto.getContact());
	patientRepository.save(patient);
	return "patient registered successfully";
}
//patient can delete the details 
 Patient patient=new Patient();
 public String deletePatientById(long id) {
	Optional<Patient> patient=patientRepository.findById(id);
	 if(patient.isPresent()) {
		 patientRepository.deleteById(id);
		 return "patient details deleted successfully";
		 
	 }
	 else {
		 return "patient ID not found";
	 }
 }
	
}
