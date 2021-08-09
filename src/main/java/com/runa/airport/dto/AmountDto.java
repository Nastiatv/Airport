package com.runa.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AmountDto {

    private int departingFlight;
    private int departingPieces;
    private int arrivingFlight;
    private int arrivingPieces;
}