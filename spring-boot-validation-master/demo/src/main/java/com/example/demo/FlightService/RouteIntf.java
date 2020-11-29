package com.example.demo.FlightService;

import java.util.Optional;

import com.example.demo.FlightModel.Route;

public interface RouteIntf {
	Iterable<Route> findAll();
	Optional<Route> findById(Long routeUniqueName);
	Route save(Route model);
}
