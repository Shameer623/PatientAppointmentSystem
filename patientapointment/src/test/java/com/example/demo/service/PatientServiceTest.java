

package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.Optional;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.Dto.PatientDto;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private PatientDto patientDto;
    private Patient patient;

    @BeforeEach
    public void setUp() {
        patientDto = new PatientDto();
        patientDto.setFirstname("John");
        patientDto.setLastname("Doe");
        patientDto.setContact("123456789");

        patient = new Patient();
        patient.setFirstname("John");
        patient.setLastname("Doe");
        patient.setContact("123456789");
    }

    @Test
    public void testGetAllPatients() {
        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient));
        List<Patient> patients = patientService.getAllPatients();
        assertEquals(1, patients.size());
        assertEquals(patient.getFirstname(), patients.get(0).getFirstname());
    }




    @Test
    public void testRegisterPatient_success() {
        when(patientRepository.findByFirstname(patientDto.getFirstname())).thenReturn(Optional.empty());
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        String response = patientService.registerPatient(patientDto);
        assertEquals("patient registered successfully", response);
    }

    @Test
    public void testDeletePatientById_success() {
        when(patientRepository.findById(any(Long.class))).thenReturn(Optional.of(patient));
        doNothing().when(patientRepository).deleteById(any(Long.class));

        String response = patientService.deletePatientById(1L);
        assertEquals("patient details deleted successfully", response);

        verify(patientRepository, times(1)).deleteById(any(Long.class));
    }

    @Test
    public void testDeletePatientById_notFound() {
        when(patientRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        String response = patientService.deletePatientById(1L);
        assertEquals("patient ID not found", response);
    }
}

