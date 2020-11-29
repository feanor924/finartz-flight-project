package com.example.demo.FlightService;

import java.util.Optional;

import com.example.demo.FlightModel.Airport;

public interface AirportIntf {
	Iterable<Airport> findAll();
	Optional<Airport> findById(Long airportName);
	Airport save(Airport model);
}
