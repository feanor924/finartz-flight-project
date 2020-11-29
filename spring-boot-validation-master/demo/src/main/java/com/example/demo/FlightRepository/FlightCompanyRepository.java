package com.example.demo.FlightRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.FlightModel.Flight;
import com.example.demo.FlightModel.FlightCompany;

public interface FlightCompanyRepository extends CrudRepository<FlightCompany, Long> {
    
}
