package com.runa.airport.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Cargo {

    @Id
    private String flightId;
    private List<Baggage> baggage;
    private List<Baggage> cargo;
}
