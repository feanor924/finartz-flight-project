package com.example.demo.FlightController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.ResourceError;
import com.example.demo.FlightModel.Flight;
import com.example.demo.FlightModel.TicketModel;
import com.example.demo.FlightService.TicketService;
import com.example.demo.utilities.Utilities;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ShortBuilder;
import com.example.demo.FlightService.FlightService;

import java.util.*;


@RestController
@RequestMapping("/api")
public class FlightController {

    @Autowired
    FlightService flightService;
    
    @Autowired
    TicketService ticketService;
   
   
    @RequestMapping(value = "/insertFlight", method = RequestMethod.POST,consumes={"application/json"})
    public Flight addFlight(@RequestBody Flight flight) {
		return flightService.save(flight);
    }

	@RequestMapping(value = "/getAllFlight", method = RequestMethod.GET)
    public Object getAllFlight() {
		return flightService.findAll();
    }

	
	@RequestMapping(value = "/getFlight/{id}", method = RequestMethod.GET)
    public Object getFlight(@PathVariable(value = "id") Long id) {
		return flightService.findById(id);
    }
	
    @RequestMapping(value = "/buyTicketToFlight/{flightId}/ticketModel", method = RequestMethod.POST,consumes={"application/json"})
    public Flight buyTicket(@PathVariable(value = "flightId") Long flightId, @RequestBody TicketModel ticketModel) {
    	
    	Optional<Flight> flight = flightService.findById(flightId);
    	
    	if ( flight.isPresent()){
    		Flight flight_ = flight.get();
    		
    		if (flight_.getNumberOfTickets() != null && flight_.getNumberOfTickets().equals(0L)){
    			throw new ResourceError("There is not enough passenger seat, please try later");
    		}
    		else{
    			if (flight_.getTicketPrice() != null && flight_.getTicketPrice().compareTo(ticketModel.getBalance()) > 0 ){
    				throw new ResourceError("Insufficient Balance for CreditCard");
    			}
    			else{
    				Map<Boolean,Long> minBalance = Utilities.calculateMinBalance(flight_,Utilities.isContainDifferentCharAndMasked(ticketModel.getCreditCardNumber()));
    				if ( !flight_.getTicketModel().isEmpty() && minBalance.get(Boolean.TRUE) != null){
    					ticketModel.setCreditCardNumber(Utilities.isContainDifferentCharAndMasked(ticketModel.getCreditCardNumber()));
    					ticketModel.setBalance(minBalance.get(Boolean.TRUE)-flight_.getTicketPrice());
						flight_.setNumberOfTickets(flight_.getNumberOfTickets()-1L);
						flight_.getTicketModel().add(ticketModel);
    				}
    				else{  					
    					ticketModel.setCreditCardNumber(Utilities.isContainDifferentCharAndMasked(ticketModel.getCreditCardNumber()));
    					ticketModel.setBalance(ticketModel.getBalance()-flight_.getTicketPrice());
    					flight_.setNumberOfTickets(flight_.getNumberOfTickets()-1L);
    					flight_.getTicketModel().add(ticketModel); 
    				}
    			}
    		}
    		return flightService.save(flight_);
    	}
    	throw new ResourceError("There is no flight like this");
    }
    
    
    
    @RequestMapping(value = "/removeTicketFromFlight/{flightId}/ticketModel", method = RequestMethod.POST,consumes={"application/json"})
    public Flight removeTicket(@PathVariable(value = "flightId") Long flightId, @RequestBody TicketModel ticketModel) {
    	
    	Optional<Flight> flightList = flightService.findById(flightId);
    	
    	if ( flightList.isPresent() ){
    		Flight flight_ = flightList.get();
    		for (int i = 0; i < flight_.getTicketModel().size(); ++i){
				if ( flight_.getTicketModel().get(i).getTicketNo().equals(ticketModel.getTicketNo())){
    				flight_.setNumberOfTickets(flight_.getNumberOfTickets()+1L); 
    				flight_.getTicketModel().remove(i);
    				ticketService.remove(ticketModel);
    				return flightService.save(flight_);
				}
			}	
			throw new ResourceError("There is no ticket like this");
    	}
    	throw new ResourceError("There is no flight like this");
    }

}
