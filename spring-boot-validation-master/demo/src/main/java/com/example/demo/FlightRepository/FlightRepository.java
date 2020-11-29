package com.example.demo.FlightRepository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.FlightModel.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    
}
