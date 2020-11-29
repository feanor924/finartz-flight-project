package com.example.demo.FlightService;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.FlightModel.Flight;

public interface FlightServiceIntf {

	Iterable<Flight> findAll();
	Optional<Flight> findById(Long id);
	Flight save(Flight model);
	
}
