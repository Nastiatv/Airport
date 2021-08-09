package com.runa.airport.controller;

import com.runa.airport.dto.AmountDto;
import com.runa.airport.dto.WeightDto;
import com.runa.airport.model.enumerator.IATACode;
import com.runa.airport.service_api.IFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("flight")
@RequiredArgsConstructor
public class FlightController {
    private final IFlightService flightService;

    @GetMapping("/weight/{flightNumber}/{date}")
    public ResponseEntity<WeightDto> getWeight(@PathVariable int flightNumber,
                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(flightService.getWeight(flightNumber, date));
    }

    @GetMapping("/amount/{airportIATACode}/{date}")
    public ResponseEntity<AmountDto> getAmount(@PathVariable IATACode airportIATACode,
                                               @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(flightService.getAmount(airportIATACode, date));
    }
}
