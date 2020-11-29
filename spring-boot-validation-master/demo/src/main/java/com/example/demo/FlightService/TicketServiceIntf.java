package com.example.demo.FlightService;

import java.util.List;
import java.util.Optional;

import com.example.demo.FlightModel.TicketModel;

public interface TicketServiceIntf {
	Iterable<TicketModel> findAll();
	TicketModel save(TicketModel model);
	void remove(TicketModel model);
	Optional<TicketModel> findTicket(TicketModel model);
}
