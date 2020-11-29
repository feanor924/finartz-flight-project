package com.example.demo.FlightService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FlightModel.Route;
import com.example.demo.FlightRepository.RouteRepository;

import io.swagger.annotations.Api;

@Service
@Api(value = "Route Rest Api", description = "Route Rest Service")
public class RouteService implements RouteIntf{
	@Autowired
 	RouteRepository routeRepository;	

	@Override
	public Iterable<Route> findAll() {
		return routeRepository.findAll();
	}

	@Override
	public Optional<Route> findById(Long routeUniqueName) {
		return routeRepository.findById(routeUniqueName);
	}

	@Override
	public Route save(Route model) {
		return routeRepository.save(model);
	}
	
}
