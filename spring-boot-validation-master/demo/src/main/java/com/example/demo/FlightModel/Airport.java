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
@Table(name = "AIRPORT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "airportUniqueName")
public class Airport {


	@Column(name = "AIRPORT_NAME")
    private String airportName;
	
	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportLocation() {
		return airportLocation;
	}

	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}

	public Long getAirportUniqueName() {
		return airportUniqueName;
	}

	public void setAirportUniqueName(Long airportUniqueName) {
		this.airportUniqueName = airportUniqueName;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@Column(name = "AIRPORT_LOCATION")
    private String airportLocation;
	
	@Id
	@Column(name = "AIRPORT_UNIQUE_NAME")
    private Long airportUniqueName;
	
	@OneToMany(mappedBy = "airport", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
	private Set<Flight> flights = new HashSet<Flight>();
	

}
