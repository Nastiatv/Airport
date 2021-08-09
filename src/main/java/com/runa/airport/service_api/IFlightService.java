package com.runa.airport.service_api;

import com.runa.airport.dto.AmountDto;
import com.runa.airport.dto.WeightDto;
import com.runa.airport.model.enumerator.IATACode;

import java.time.LocalDate;

public interface IFlightService {

    WeightDto getWeight(int flightNumber, LocalDate date);

    AmountDto getAmount(IATACode airportIATACode, LocalDate date);
}
