package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.DoctorDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

import com.example.demo.model.Doctor; 
@Service
public class DoctorService {
@Autowired
 private DoctorRepository doctorRepository;

public List<Doctor> getAllDoctors(){
	return doctorRepository.findAll();
}

//public String addDoctor(DoctorDto doctorDto) {
//	
//	Doctor doctor=new Doctor();
//	doctor.setName(doctorDto.getDoctorName());
//	doctor.setSpecialization(doctorDto.getSpecialization());
//	doctorRepository.save(doctor);
//	return "Doctor added successfully";
//	
//}
public String addDoctor(DoctorDto doctorDto) {
    if (doctorDto == null) {
        return "Doctor data is null";
    }

    Doctor doctor = new Doctor();
    doctor.setName(doctorDto.getName());
    doctor.setSpecialization(doctorDto.getSpecialization());
    doctorRepository.save(doctor);
    return "Doctor added successfully";
}

public Doctor getDoctorById(Long doctorId) {
	Optional<Doctor> doctor=doctorRepository.findById(doctorId);
	return doctor.orElse(null);
}


public String deleteDoctor(Long doctorId) {
 Doctor doctor=doctorRepository.findById(doctorId).orElse(null);
if(doctor!=null) {
	doctorRepository.deleteById(doctorId);
	return "Doctor deleted successfully";
}
else{
	
	return "doctor id not found";
}
}


 public String updateDoctor(DoctorDto doctorDto) { 
	 Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorDto.getDoctorId());
	 if (optionalDoctor.isPresent()) {
		 Doctor doctor = optionalDoctor.get();
	 doctor.setName(doctorDto.getName()); 
	 doctor.setSpecialization(doctorDto.getSpecialization());
	 doctorRepository.save(doctor);
	 return "Doctor updated successfully";
	 }
	 
	 else {
		 return "Doctor ID not found";
		 }
 }

}
