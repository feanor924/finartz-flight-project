package com.example.demo.FlightRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.FlightModel.Airport;

public interface AirportRepository extends CrudRepository<Airport, Long> {
    
}
