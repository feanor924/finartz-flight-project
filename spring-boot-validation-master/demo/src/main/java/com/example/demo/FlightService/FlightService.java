package com.example.demo.FlightService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FlightModel.Flight;
import com.example.demo.FlightRepository.FlightRepository;

import io.swagger.annotations.Api;

@Service
@Api(value = "Flight Rest Api", description = "Flight Rest Service")
public class FlightService implements FlightServiceIntf{
	 @Autowired
	 FlightRepository flightRepository;

	@Override
	public Iterable<Flight> findAll() {
		return flightRepository.findAll();
	}

	@Override
	public Optional<Flight> findById(Long id) {
		return flightRepository.findById(id);
	}

	@Override
	public Flight save(Flight model) {
		return flightRepository.save(model);
	}

	
}
