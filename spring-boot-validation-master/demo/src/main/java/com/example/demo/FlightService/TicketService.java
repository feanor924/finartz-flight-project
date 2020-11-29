package com.example.demo.FlightService;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.FlightModel.TicketModel;
import com.example.demo.FlightRepository.TicketRepository;

@Service
public class TicketService implements TicketServiceIntf {

	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public Iterable<TicketModel> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public TicketModel save(TicketModel model) {
		return ticketRepository.save(model);
	}

	@Override
	public void remove(TicketModel model) {
		ticketRepository.deleteById(model.getTicketNo());
	}
	
	@Override
	public Optional<TicketModel> findTicket(TicketModel model) {
		return ticketRepository.findById(model.getTicketNo());
	}
}
