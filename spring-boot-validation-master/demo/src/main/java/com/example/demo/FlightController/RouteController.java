package com.example.demo.FlightController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.FlightModel.Route;
import com.example.demo.FlightService.RouteService;

@RestController
@RequestMapping("/api")
public class RouteController {
	
	@Autowired
	RouteService routeService;
	
	
	@RequestMapping(value = "/insertRoute", method = RequestMethod.POST,consumes={"application/json"})
    public Route addAirport(@RequestBody Route route) {
		return routeService.save(route);
    }

	@RequestMapping(value = "/getAllRoute", method = RequestMethod.GET,consumes={"application/json"})
    public Object getAllRoute() {
		return routeService.findAll();
    }

	
	@RequestMapping(value = "getRoute/{routeName}", method = RequestMethod.GET)
    public Object getAirport(@PathVariable(value = "routeName") Long routeUniqueName) {
		return routeService.findById(routeUniqueName);
    }

}
