package com.example.demo.FlightRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.FlightModel.Route;

public interface RouteRepository extends CrudRepository<Route, Long> {
    
}
