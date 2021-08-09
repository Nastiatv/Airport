package com.runa.airport.repository;

import com.runa.airport.model.Flight;
import com.runa.airport.model.enumerator.IATACode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlightRepository extends MongoRepository<Flight, String> {

    List<Flight> findByFlightNumber(final int flightNumber);

    List<Flight> findByDepartureAirportIATACode(final IATACode iataCode);

    List<Flight> findByArrivalAirportIATACode(final IATACode iataCode);
}