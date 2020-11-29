package com.example.demo.FlightController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FlightModel.Airport;
import com.example.demo.FlightService.AirportService;

@RestController
@RequestMapping("/api") 
public class AirportController {
    @Autowired
    AirportService airportService;

   
    @RequestMapping(value = "/insertAirport", method = RequestMethod.POST,consumes={"application/json"})
    public Airport addAirport(@RequestBody Airport airport) {
		return airportService.save(airport);
    }

	@RequestMapping(value = "/getAllAirport", method = RequestMethod.GET,consumes={"application/json"})
    public Object getAllAirport() {
		return airportService.findAll();
    }

	
	@RequestMapping(value = "getAirport/{airportName}", method = RequestMethod.GET)
    public Object getAirport(@PathVariable(value = "airportName") Long airportName) {
		return airportService.findById(airportName);
    }
}
