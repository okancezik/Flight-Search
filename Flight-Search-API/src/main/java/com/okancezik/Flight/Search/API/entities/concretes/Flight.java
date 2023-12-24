package com.okancezik.Flight.Search.API.entities.concretes;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departure_airport_id", referencedColumnName = "id")
	private Airport departureAirport;
	 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "arrival_airport_id", referencedColumnName = "id") 
	private Airport arrivalAirport;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "departure_datetime")
    private LocalDateTime departureDateTime;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_datetime")
    private LocalDateTime returnDateTime;
    
    @Column(name = "price")
    private double price;
}
