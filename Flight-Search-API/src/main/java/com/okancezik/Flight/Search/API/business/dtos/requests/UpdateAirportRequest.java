package com.okancezik.Flight.Search.API.business.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAirportRequest {

	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	private String city;
}
