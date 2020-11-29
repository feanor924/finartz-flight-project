package com.example.demo.FlightRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.FlightModel.Flight;
import com.example.demo.FlightModel.TicketModel;

public interface TicketRepository extends CrudRepository<TicketModel, Long> {
}
