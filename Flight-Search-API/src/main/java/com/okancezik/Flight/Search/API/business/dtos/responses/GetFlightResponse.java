package com.okancezik.Flight.Search.API.business.dtos.responses;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFlightResponse {
	
	private String departureAirportCity;
	 
	private String arrivalAirportCity;
	
    private Date departureDateTime;
    
    private Date returnDateTime;

    private double price;
}
