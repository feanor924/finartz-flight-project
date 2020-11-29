package com.example.demo.FlightService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FlightModel.Airport;
import com.example.demo.FlightRepository.AirportRepository;

import io.swagger.annotations.Api;

@Service
@Api(value = "AirportService Rest Api", description = "AirportService Rest Service")
public class AirportService implements AirportIntf{
	@Autowired
	 AirportRepository airportRepository;

	@Override
	public Iterable<Airport> findAll() {
		return airportRepository.findAll();
	}

	@Override
	public Optional<Airport> findById(Long airportName) {
		return airportRepository.findById(airportName);
	}

	@Override
	public Airport save(Airport model) {
		return airportRepository.save(model);
	}
}
