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
@Table(name = "ROUTE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "routeIdCompany")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROUTE_ID_COMPANY")
    private Long routeIdCompany;
	

	@Column(name = "DEPARTURE")
    private String departure;
	
	@Column(name = "DESTINATION")
    private String destination;
	
	public Long getRouteIdCompany() {
		return routeIdCompany;
	}

	public void setRouteIdCompany(Long routeIdCompany) {
		this.routeIdCompany = routeIdCompany;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@Column(name = "ROUTE_NAME")
    private String routeName;
	
	@OneToMany(mappedBy = "route",fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<Flight> flights = new HashSet<Flight>();
	
}
