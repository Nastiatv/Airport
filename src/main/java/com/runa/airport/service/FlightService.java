package com.runa.airport.service;

import com.runa.airport.dto.AmountDto;
import com.runa.airport.dto.WeightDto;
import com.runa.airport.model.Baggage;
import com.runa.airport.model.Cargo;
import com.runa.airport.model.Flight;
import com.runa.airport.model.enumerator.IATACode;
import com.runa.airport.model.enumerator.WeightUnit;
import com.runa.airport.repository.IFlightRepository;
import com.runa.airport.service_api.ICargoService;
import com.runa.airport.service_api.IFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightService implements IFlightService {
    private final IFlightRepository flightRepository;
    private final ICargoService cargoService;

    public WeightDto getWeight(int flightNumber, LocalDate date) {
        List<Flight> flights = flightRepository.findByFlightNumber(flightNumber);
        Flight first = getFlightsOnDate(date, flights).stream().findFirst().orElseThrow(() ->
                new EntityNotFoundException(String.format("Unable to get flight with  %s number", flightNumber)));
        Cargo cargo = cargoService.findByFlightId(first.getFlightId());
        int cargoWeight = getWeight(cargo.getCargo());
        int baggageWeight = getWeight(cargo.getBaggage());
        return new WeightDto(cargoWeight, baggageWeight, cargoWeight + baggageWeight);
    }

    public AmountDto getAmount(IATACode airportIATACode, LocalDate date) {
        List<Flight> departureFlights = flightRepository.findByDepartureAirportIATACode(airportIATACode);
        List<Flight> departureOnDate = getFlightsOnDate(date, departureFlights);
        Set<Cargo> departureCargos = getCargos(departureOnDate);

        List<Flight> arrivalFlights = flightRepository.findByArrivalAirportIATACode(airportIATACode);
        List<Flight> arrivalOnDate = getFlightsOnDate(date, arrivalFlights);
        Set<Cargo> arrivalCargos = getCargos(arrivalOnDate);
        return new AmountDto(departureOnDate.size(), getPieces(departureCargos), arrivalOnDate.size(), getPieces(arrivalCargos));
    }

    private List<Flight> getFlightsOnDate(LocalDate date, List<Flight> flights) {
        return flights.stream().filter(flight -> date.compareTo(flight.getDepartureDate().toLocalDate()) == 0)
                .collect(Collectors.toList());
    }

    private Set<Cargo> getCargos(List<Flight> flights) {
        Set<String> flightsIds = flights.stream().map(Flight::getFlightId).collect(Collectors.toSet());
        return cargoService.findAllByFlightIdIsIn(flightsIds);
    }

    private int getPieces(Set<Cargo> cargos) {
        return cargos.stream().mapToInt(cargo -> getPieces(cargo.getCargo()) + getPieces(cargo.getBaggage())).sum();
    }

    private int getPieces(List<Baggage> baggageList) {
        return baggageList.stream().mapToInt(Baggage::getPieces).sum();
    }


    private int getWeight(List<Baggage> baggageList) {
        return baggageList.stream().mapToInt(baggage -> {
            if (baggage.getWeightUnit() == WeightUnit.kg) {
                return baggage.getWeight();
            } else {
                return (int) (baggage.getWeight() * 0.453592);
            }
        }).sum();
    }
}
