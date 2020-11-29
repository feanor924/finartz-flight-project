package com.example.demo.FlightController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FlightModel.TicketModel;
import com.example.demo.FlightService.TicketService;

@RestController
@RequestMapping("/api") 
public class TicketController {

    @Autowired
    TicketService ticketService;
    
	@RequestMapping(value = "/getTicket", method = RequestMethod.GET)
    public Object getTicket(@RequestBody TicketModel ticketModel) {
		return ticketService.findTicket(ticketModel);
    }
	
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public Object addTicket(@RequestBody TicketModel ticketModel) {
		return ticketService.save(ticketModel);
    }
	
	@RequestMapping(value = "/getAllTickets", method = RequestMethod.GET)
    public Object getAllTickets() {
		return ticketService.findAll();
    }
}
