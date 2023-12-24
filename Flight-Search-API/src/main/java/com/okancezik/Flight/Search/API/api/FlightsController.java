package com.okancezik.Flight.Search.API.api;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.okancezik.Flight.Search.API.business.abstracts.FlightService;
import com.okancezik.Flight.Search.API.business.dtos.requests.CreateFlightRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetFlightResponse;
import com.okancezik.Flight.Search.API.core.results.DataResult;
import com.okancezik.Flight.Search.API.core.results.ErrorDataResult;
import com.okancezik.Flight.Search.API.core.results.SuccessDataResult;
import com.okancezik.Flight.Search.API.entities.concretes.Flight;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/flight")
@Slf4j
public class FlightsController {

	@Autowired
	private FlightService flightService;

	@PostMapping
	public DataResult<GetFlightResponse> save(@RequestBody CreateFlightRequest createFlightRequest) {
		log.info("PRICE : " + createFlightRequest.getPrice());
		GetFlightResponse response = this.flightService.save(createFlightRequest);

		if (response != null) {
			return new SuccessDataResult<GetFlightResponse>(response, "added flight");
		}
		return new ErrorDataResult<>();
	}

	@GetMapping
	public DataResult<List<GetFlightResponse>> getAllFlights() {
		return new SuccessDataResult<List<GetFlightResponse>>(this.flightService.getAllFlight(), "listed flights");
	}

	@GetMapping("{departure}")
	public DataResult<List<GetFlightResponse>> getAllFlightsByDeparture(@PathVariable String departure) {
		List<GetFlightResponse> response = this.flightService.getAllFlightsByDeparture(departure);
		return new SuccessDataResult<List<GetFlightResponse>>(response, "listed flights");
	}

	@GetMapping("{arrival}")
	public DataResult<List<GetFlightResponse>> getAllFlightsByArrival(@PathVariable String arrival) {
		List<GetFlightResponse> response = this.flightService.getAllFlightsByDeparture(arrival);
		return new SuccessDataResult<List<GetFlightResponse>>(response, "listed flights");
	}

	@GetMapping("/search")
	public DataResult<List<Flight>> searchFlights(@RequestParam String departure, @RequestParam String arrival,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime departureDatetime,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime returnDatetime) {
		
		List<Flight> response = this.flightService.searchFlights(departure, arrival, departureDatetime, returnDatetime);
		return new SuccessDataResult<List<Flight>>(response, "listed");
	}
}
