package com.example.demo.FlightService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FlightModel.FlightCompany;
import com.example.demo.FlightRepository.FlightCompanyRepository;

import io.swagger.annotations.Api;

@Service
@Api(value = "FlightCompany Rest Api", description = "FlightCompany Rest Service")
public class FlightCompanyService implements FlightCompanyIntf {

	 @Autowired
	 FlightCompanyRepository flightCompanyRepository;
	
	
	@Override
	public Iterable<FlightCompany> findAll() {
		return flightCompanyRepository.findAll();
	}

	@Override
	public Optional<FlightCompany> findById(Long id) {
		return flightCompanyRepository.findById(id);
	}

	@Override
	public FlightCompany save(FlightCompany model) {
		return flightCompanyRepository.save(model);
	}

}
