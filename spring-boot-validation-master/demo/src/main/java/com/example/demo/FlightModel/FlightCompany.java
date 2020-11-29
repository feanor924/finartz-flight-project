package com.example.demo.FlightModel;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "FLIGHT_COMPANY")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightIdCompany")
public class FlightCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FLIGHT_ID_COMPANY")
    private Long flightIdCompany;
	
	@Column(name = "FLIGHT_COMPANY_NAME")
    private String flightCompanyName;

	public Long getFlightIdCompany() {
		return flightIdCompany;
	}

	public void setFlightIdCompany(Long flightIdCompany) {
		this.flightIdCompany = flightIdCompany;
	}

	public String getFlightCompanyName() {
		return flightCompanyName;
	}

	public void setFlightCompanyName(String flightCompanyName) {
		this.flightCompanyName = flightCompanyName;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@OneToMany(mappedBy = "flightCompany", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
	private Set<Flight> flights = new HashSet<Flight>();
	
	
}
