package com.runa.airport.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.runa.airport.model.enumerator.IATACode;
import com.runa.airport.utils.OffsetDateTimeDeserializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Document
@Data
public class Flight {

    @Id
    private String flightId;
    private int flightNumber;
    private IATACode departureAirportIATACode;
    private IATACode arrivalAirportIATACode;
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime departureDate;
}
