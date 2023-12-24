package com.okancezik.Flight.Search.API.entities.concretes;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ID;
	
	@ManyToOne
	@JoinColumn(name = "departure_airport_id")
	private Airport departureAirport;
	 
	@ManyToOne
	@JoinColumn(name = "arrival_airport_id") 
	private Airport arrivalAirport;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_datetime")
    private Date departureDateTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_datetime")
    private Date returnDateTime;
    
    @Column(name = "price")
    private double price;
}
