package com.okancezik.Flight.Search.API.business.abstracts;

import java.util.List;

import com.okancezik.Flight.Search.API.business.dtos.requests.CreateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.DeleteAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.UpdateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetAirportResponse;


public interface AirportService {
	
	GetAirportResponse save(CreateAirportRequest createAirportRequest); 
	GetAirportResponse getAirportById(int id);
	GetAirportResponse delete(DeleteAirportRequest deleteAirportRequest);
	GetAirportResponse update(UpdateAirportRequest updateAirportRequest);
	List<GetAirportResponse> getAllAirport();
}
