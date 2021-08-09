package com.runa.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeightDto {

    private int cargo;
    private int baggage;
    private int total;
}