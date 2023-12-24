package com.okancezik.Flight.Search.API.repositories.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okancezik.Flight.Search.API.entities.concretes.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer> {

	List<Flight> findByDepartureAirportCity(String departure);

	List<Flight> findByArrivalAirportCity(String arrival);

	List<Flight> findByDepartureAirportCityAndArrivalAirportCity(String departure, String arrival);

	List<Flight> findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeGreaterThanEqual(String departure,
			String arrival, LocalDateTime departureDatetime);

	List<Flight> findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateTimeGreaterThanEqualAndReturnDateTimeLessThanEqual(
			String departureCity, String arrivalCity, LocalDateTime departureDateTime, LocalDateTime returnDateTime);
}
