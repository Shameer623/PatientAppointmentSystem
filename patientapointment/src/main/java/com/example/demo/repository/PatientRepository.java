package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

//intract with database jap repo is spring framework provide we use the crud and extract it
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByFirstname(String firstname);
}
