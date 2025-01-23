
package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Userr;


public interface UserrRepository extends JpaRepository<Userr,Integer> {

	 Optional<Userr> findByName(String name);
}
