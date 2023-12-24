package com.okancezik.Flight.Search.API.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okancezik.Flight.Search.API.business.abstracts.AirportService;
import com.okancezik.Flight.Search.API.business.dtos.requests.CreateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.DeleteAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.UpdateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetAirportResponse;
import com.okancezik.Flight.Search.API.core.mappers.ModelMapperService;
import com.okancezik.Flight.Search.API.entities.concretes.Airport;
import com.okancezik.Flight.Search.API.repositories.abstracts.AirportDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportManager implements AirportService {

	@Autowired
	private AirportDao airportDao;
	private final ModelMapperService mapperService;

	@Override
	public GetAirportResponse save(CreateAirportRequest createAirportRequest) {

		if (createAirportRequest != null) {
			Airport airport = this.mapperService.forRequest().map(createAirportRequest, Airport.class);
			return this.mapperService.forResponse().map(this.airportDao.save(airport), GetAirportResponse.class);
		}
		return null;
	}

	@Override
	public GetAirportResponse getAirportById(int id) {
		Optional<Airport> airport = this.airportDao.findById(id);
		if (airport.isPresent()) {
			return this.mapperService.forResponse().map(airport.get(), GetAirportResponse.class);
		}
		return null;
	}

	@Override
	public GetAirportResponse delete(DeleteAirportRequest deleteAirportRequest) {
		Airport airport = this.mapperService.forRequest().map(deleteAirportRequest, Airport.class);
		if (airport != null) {
			this.airportDao.delete(airport);
			return this.mapperService.forResponse().map(airport, GetAirportResponse.class);
		}
		return null;
	}

	@Override
	public GetAirportResponse update(UpdateAirportRequest updateAirportRequest) {
		if (updateAirportRequest != null) {
			Airport airport = this.mapperService.forRequest().map(updateAirportRequest, Airport.class);
			Optional<Airport> existingAirport = this.airportDao.findById(airport.getId());
			if (existingAirport.isPresent()) {
				existingAirport.get().setCity(airport.getCity());
				this.airportDao.save(existingAirport.get());
				return this.mapperService.forResponse().map(existingAirport.get(), GetAirportResponse.class);
			} else {
				return null;
			}
		}

		return null;
	}

	@Override
	public List<GetAirportResponse> getAllAirport() {
		List<Airport> airports = this.airportDao.findAll();

		List<GetAirportResponse> response = airports.stream()
				.map(airport -> this.mapperService.forResponse().map(airport, GetAirportResponse.class))
				.collect(Collectors.toList());
		
		return response;
	}

}
