package com.example.demo.FlightService;

import java.util.Optional;

import com.example.demo.FlightModel.FlightCompany;

public interface FlightCompanyIntf {

		Iterable<FlightCompany> findAll();
		Optional<FlightCompany> findById(Long id);
		FlightCompany save(FlightCompany model);
		
}

