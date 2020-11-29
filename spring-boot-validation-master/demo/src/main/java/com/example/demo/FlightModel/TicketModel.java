package com.example.demo.FlightModel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "TICKET")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ticketNo")
public class TicketModel {
	
	@Id
	@Column(name = "TICKET_NO")
    private Long ticketNo;
	
	
	public Long getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(Long ticketNo) {
		this.ticketNo = ticketNo;
	}

	@Column(name = "CREDIT_CARD_NO")
    private String creditCardNumber;


	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Flight flight;
	
	
	public Flight getFlights() {
		return flight;
	}

	public void setFlights(Flight flight) {
		this.flight = flight;
	}

	@Column(name = "BALANCE")
	private Long balance;
}
