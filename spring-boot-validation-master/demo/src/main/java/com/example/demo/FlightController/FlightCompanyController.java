package com.example.demo.FlightController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FlightModel.FlightCompany;
import com.example.demo.FlightService.FlightCompanyService;

@RestController
@RequestMapping("/api")
public class FlightCompanyController {

	@Autowired
	FlightCompanyService flightCompanyService;
	
    @RequestMapping(value = "/addFlightCompanyService", method = RequestMethod.POST,consumes={"application/json"})
    public FlightCompany addFlightCompanyService(@RequestBody FlightCompany flightCompany) {
		return flightCompanyService.save(flightCompany);
    }

	@RequestMapping(value = "/getAllFlightCompanyService", method = RequestMethod.GET,consumes={"application/json"})
    public Object getAllFlightCompanyService() {
		return flightCompanyService.findAll();
    }

	
	@RequestMapping(value = "getFlightCompanyService/{id}", method = RequestMethod.GET)
    public Object getFlightFlightCompanyService(@PathVariable(value = "id") Long id) {
		return flightCompanyService.findById(id);
    }
	
}
