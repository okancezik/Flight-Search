package com.okancezik.Flight.Search.API.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okancezik.Flight.Search.API.business.abstracts.AirportService;
import com.okancezik.Flight.Search.API.business.dtos.requests.CreateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.DeleteAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.requests.UpdateAirportRequest;
import com.okancezik.Flight.Search.API.business.dtos.responses.GetAirportResponse;
import com.okancezik.Flight.Search.API.core.results.DataResult;
import com.okancezik.Flight.Search.API.core.results.ErrorDataResult;
import com.okancezik.Flight.Search.API.core.results.SuccessDataResult;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportsApi {
	
	@Autowired
	private AirportService airportService;
	
	@PostMapping
	public DataResult<GetAirportResponse> save(@RequestBody CreateAirportRequest createAirportRequest){
		GetAirportResponse saved = this.airportService.save(createAirportRequest);
		if(saved!=null) {
			return new SuccessDataResult<GetAirportResponse>(saved,"airport added");
		}
		return new ErrorDataResult<>();
	}
	
	@GetMapping("/{id}")
	public DataResult<GetAirportResponse> getByIdAirport(@PathVariable int id){
		GetAirportResponse airport = this.airportService.getAirportById(id);
		if(airport != null) {
			return new SuccessDataResult<GetAirportResponse>(airport, "airport listed");
		}
		return new ErrorDataResult<>("not found airport");
	}
	
	@GetMapping()
	public DataResult<List<GetAirportResponse>> getAllAirport(){
		List<GetAirportResponse> airports = this.airportService.getAllAirport();
		if(airports != null) {
			return new SuccessDataResult<List<GetAirportResponse>>(airports, "airport listed");
		}
		return new ErrorDataResult<>("not found airport");
	}
	
	@DeleteMapping
	public DataResult<GetAirportResponse> deleteAirport(@RequestBody DeleteAirportRequest deleteAirportRequest){
		GetAirportResponse airport = this.airportService.delete(deleteAirportRequest);
		
		if(airport != null) {
			return new SuccessDataResult<GetAirportResponse>(airport, "airport deleted");
		}
		return new ErrorDataResult<>("not found airport");
	}
	
	@PutMapping
	public DataResult<GetAirportResponse> updateAirport(@RequestBody UpdateAirportRequest updateAirportRequest){
		GetAirportResponse airport = this.airportService.update(updateAirportRequest);
		if(airport != null) {
			return new SuccessDataResult<GetAirportResponse>(airport, "updated airport");
		}
		return new ErrorDataResult<>("not found airport");
	}
}
