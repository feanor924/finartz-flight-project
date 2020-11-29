package com.example.demo.FlightModel;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "FLIGHT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightId")
public class Flight {

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public FlightCompany getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(FlightCompany flightCompany) {
		this.flightCompany = flightCompany;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLIGHT_ID")
    private Long flightId;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}


	public Long getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(Long numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	@ApiModelProperty(notes = "The ticket price of flight")
	@Column(name = "TICKET_PRICE")
    private Long ticketPrice;


	public Long getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Long ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@ApiModelProperty(notes = "The number of tickets of flight")
	@Column(name = "NUMBER_OF_TICKETS")
    private Long numberOfTickets;

	@ApiModelProperty(notes = "The name of flight")
	@Column(name = "FLIGHT_NAME")
    private String flightName;

	@ApiModelProperty(notes = "The route name of flight")
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ROUTE_NAME")
	private Route route;
    
	@ApiModelProperty(notes = "The flight company of flight")
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "FLIGHT_COMPANY_NAME")
	private FlightCompany flightCompany;
    
	@ApiModelProperty(notes = "The airport name of flight")
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "AIRPORT_NAME")
	private Airport airport;
    
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<TicketModel> ticketModel;

	public List<TicketModel> getTicketModel() {
		return ticketModel;
	}

	public void setTicketModel(List<TicketModel> creditCardModel) {
		this.ticketModel = creditCardModel;
	}

	public Airport getAirport() {
		return airport;
	}


	public void setAirport(Airport airport) {
		this.airport = airport;
	}


}
