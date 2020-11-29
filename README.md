# finartz-flight-project



http://localhost:8080/swagger-ui.html#/





Örnek requestler:

Aşağıdaki requestler sırayla çalıştırılabilir.


localhost:8080/api/insertFlight

{
    "flightId": 1,
    "ticketPrice": 10000,
    "numberOfTickets": 5,
    "flightName": "PEGASUS-ILK-UCUS",
    "route": {
        "routeIdCompany": 1,
        "departure": "ISTANBUL",
        "destination": "IZMIR",
        "routeName": "II-324"
    },
    "flightCompany": {
        "flightIdCompany": 1,
        "flightCompanyName": "PEGASUS"
    },
    "airport": {
        "airportName": "ATATURK",
        "airportLocation": "ISTANBUL",
        "airportUniqueName": 12341
    },
    "ticketModel": null
}

-------------------------------------------------------------------


localhost:8080/api/buyTicketToFlight/1/ticketModel


buyTicketToFlight/1/creditCardModel

{
	"ticketNo":1,
	"creditCardNumber":"4221-1611-2233-0005",
	"balance":10000000
}

-------------------------------------------------------------------

localhost:8080/api/buyTicketToFlight/1/ticketModel

{
	"ticketNo":2,
	"creditCardNumber":"4221,1611,2233,0005",
	"balance":10000000
}

------------------------------------------------------------------

localhost:8080/api/buyTicketToFlight/1/ticketModel

{
	"ticketNo":3,
	"creditCardNumber":"4221161122330005",
	"balance":10000000
}


-------------------------------------------------------------------

localhost:8080/api/getAllTickets



-------------------------------------------------------------------

localhost:8080/api/removeTicketFromFlight/1/ticketModel

{
	"ticketNo":1
}

-------------------------------------------------------------------

localhost:8080/api/getAllTickets

-------------------------------------------------------------------

localhost:8080/api/getAllFlight


-------------------------------------------------------------------

localhost:8080/api/getAllRoute


-------------------------------------------------------------------

localhost:8080/api/getAllAirport

-------------------------------------------------------------------


