package com.okancezik.Flight.Search.API.repositories.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okancezik.Flight.Search.API.entities.concretes.Airport;

public interface AirportDao extends JpaRepository<Airport, Integer>{

}
