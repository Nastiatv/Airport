package com.runa.airport.model;

import com.runa.airport.model.enumerator.WeightUnit;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Baggage {

    @Id
    private String id;
    private int weight;
    private WeightUnit weightUnit;
    private int pieces;
}
