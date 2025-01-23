package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.DoctorDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	
  @Autowired 
  private ObjectMapper objectMapper; 
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> viewAllAppointments(){
		List<Appointment> appointments=appointmentService.getAllAppointments();
		return ResponseEntity.ok(appointments);
	}
	
	@GetMapping("/patients")
	public ResponseEntity<List<Patient>> viewAllPatients(){
		List<Patient> patients=patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> viewAllDoctors(){
		List<Doctor> doctors=doctorService.getAllDoctors();
		return ResponseEntity.ok(doctors);
	}
	

	

}
