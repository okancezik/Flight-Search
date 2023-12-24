package com.okancezik.Flight.Search.API.business.dtos.requests;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateFlightRequest {

	@NotNull
	@NotBlank
	private int departureAirportId;
	 
	@NotNull
	@NotBlank
	private int arrivalAirportId;
	
	@NotNull
	@NotBlank
    private Date departureDateTime;
    
	@NotNull
	@NotBlank
    private Date returnDateTime;

	@NotNull
	@NotBlank
    private double price;
}
