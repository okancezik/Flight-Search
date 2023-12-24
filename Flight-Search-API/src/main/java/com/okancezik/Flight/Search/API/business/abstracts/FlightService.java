package com.okancezik.Flight.Search.API.business.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import com.okancezik.Flight.Search.API.business.dtos.requests.CreateFlightRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetFlightResponse;
import com.okancezik.Flight.Search.API.entities.concretes.Flight;

public interface FlightService {

	GetFlightResponse save(CreateFlightRequest createFlightRequest);

	List<GetFlightResponse> getAllFlight();

	List<GetFlightResponse> getAllFlightsByDeparture(String departure);

	List<GetFlightResponse> getAllFlightsByArrival(String arrival);

	List<Flight> searchFlights(String departure, String arrival,LocalDateTime departureDatetime, LocalDateTime returnDatetime);

}
