package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Dto.AppointmentDto;
import com.example.demo.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.bookAppointment(appointmentDto);
    }
  @DeleteMapping("/{id}")
  public ResponseEntity<String>cancelAppointment(@PathVariable  long id){
  	String response=appointmentService.cancelAppointment(id);
  	return ResponseEntity.ok(response);
  }
}




