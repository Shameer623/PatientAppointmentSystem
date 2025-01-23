//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.Dto.AppointmentDto;
//import com.example.demo.model.Appointment;
//import com.example.demo.model.Doctor;
//import com.example.demo.model.Patient;
//import com.example.demo.repository.AppointmentRepository;
//import com.example.demo.repository.DoctorRepository;
//import com.example.demo.repository.PatientRepository;
//
//@Service
//public class AppointmentService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    @Autowired
//    private DoctorRepository doctorRepository;
//
//    @Autowired
//    private PatientRepository patientRepository;
//    public List<Appointment> getAllAppointments() {
//        return appointmentRepository.findAll();
//    }
//
//    public String bookAppointment(AppointmentDto appointmentDto) {
//        Optional<Doctor> doctorOpt = doctorRepository.findByName(appointmentDto.getDoctorName());
//        Optional<Patient> patientOpt = patientRepository.findByFirstname(appointmentDto.getFirstname());
//
//        if (doctorOpt.isPresent() && patientOpt.isPresent()) {
//            Doctor doctor = doctorOpt.get();
//            Patient patient = patientOpt.get();
//
//            if (appointmentRepository.findByDoctorAndPatient(doctor, patient).isPresent()) {
//                return "User has already booked an appointment";
//            }
//
//            Appointment appointment = new Appointment();
//            appointment.setDoctor(doctor);
//            appointment.setPatient(patient);
//            appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
//            appointment.setDoctorName(appointmentDto.getDoctorName());
//            appointment.setpatientName(appointmentDto.getFirstname());
//            appointmentRepository.save(appointment);
//
//            return "Appointment booked successfully";
//        } else {
//            return "Doctor or Patient not found";
//        }
//    }
//
////	public List<Appointment> getAllAppointments() {
////		// TODO Auto-generated method stub
////		return null;
////	}
//}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.AppointmentDto;
import com.example.demo.model.Appointment;
import com.example.demo.model.Doctor;
import com.example.demo.model.Patient;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
  public List<Appointment> getAllAppointments() {
  return appointmentRepository.findAll();
}

  public String bookAppointment(AppointmentDto appointmentDto) {
	    Optional<Doctor> doctorOpt = doctorRepository.findByNameAndSpecialization(appointmentDto.getDoctorName(), appointmentDto.getSpecialization());
	    Optional<Patient> patientOpt = patientRepository.findByFirstname(appointmentDto.getFirstname());

	    if (doctorOpt.isPresent() && patientOpt.isPresent()) {
	        Doctor doctor = doctorOpt.get();
	        Patient patient = patientOpt.get();

	        if (appointmentRepository.findByDoctorAndPatient(doctor, patient).isPresent()) {
	            return "User has already booked an appointment";
	        }

	        Appointment appointment = new Appointment();
	        appointment.setDoctor(doctor);
	        appointment.setPatient(patient);
	        appointment.setSpecialization(appointmentDto.getSpecialization());
	        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
	        appointment.setStatus("booked");  
	        appointmentRepository.save(appointment);

	        return "Appointment booked successfully";
	    } else {
	        return "Doctor or Patient not found";
	    }
	}





        public String cancelAppointment(long id) {
            Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
            if (appointmentOptional.isPresent()) {
                Appointment appointment = appointmentOptional.get();
                appointment.setStatus("Canceled"); 
                appointmentRepository.save(appointment);
                return "Appointment canceled successfully";
            } else {
                return "Appointment not found";
            }
        }
    }

