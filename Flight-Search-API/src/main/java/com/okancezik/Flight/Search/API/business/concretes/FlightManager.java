package com.okancezik.Flight.Search.API.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okancezik.Flight.Search.API.business.abstracts.FlightService;
import com.okancezik.Flight.Search.API.business.dtos.requests.CreateFlightRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetFlightResponse;
import com.okancezik.Flight.Search.API.core.mappers.ModelMapperService;
import com.okancezik.Flight.Search.API.entities.concretes.Flight;
import com.okancezik.Flight.Search.API.repositories.abstracts.FlightDao;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightManager implements FlightService {

	@Autowired
	private FlightDao flightDao;
	private final ModelMapperService mapperService;

	@Transactional
	@Override
	public GetFlightResponse save(CreateFlightRequest createFlightRequest) {
		if (createFlightRequest != null) {
			Flight flight = this.mapperService.forRequest().map(createFlightRequest, Flight.class);
			this.flightDao.save(flight);
			GetFlightResponse response = this.mapperService.forResponse().map(flight, GetFlightResponse.class);
			return response;
		}
		return null;

	}

	@Override
	public List<GetFlightResponse> getAllFlight() {
		List<Flight> flights = this.flightDao.findAll();
		List<GetFlightResponse> response = flights.stream()
				.map(flight -> this.mapperService.forResponse().map(flight, GetFlightResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public List<GetFlightResponse> getAllFlightsByDeparture(String departure) {
		List<Flight> flights = this.flightDao.findByDepartureAirportCity(departure);
		List<GetFlightResponse> response = flights.stream()
				.map(flight -> this.mapperService.forResponse().map(flight, GetFlightResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public List<GetFlightResponse> getAllFlightsByArrival(String arrival) {
		List<Flight> flights = this.flightDao.findByArrivalAirportCity(arrival);
		List<GetFlightResponse> response = flights.stream()
				.map(flight -> this.mapperService.forResponse().map(flight, GetFlightResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public List<Flight> searchFlights(String departure, String arrival, LocalDateTime departureDatetime,
			LocalDateTime returnDatetime) {
		this.flightDao.findByDepartureAirportCityAndArrivalAirportCity(departure, arrival);
		
		 if (returnDatetime != null) {
	            // Çift yönlü uçuş
	            return this.flightDao.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeGreaterThanEqualAndReturnDateTimeLessThanEqual(
	                    departure, arrival, departureDatetime, returnDatetime);
	        } else {
	            // Tek yönlü uçuş
	            return this.flightDao.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeGreaterThanEqual(
	                    departure, arrival, departureDatetime);
	        }
		
	}

}
