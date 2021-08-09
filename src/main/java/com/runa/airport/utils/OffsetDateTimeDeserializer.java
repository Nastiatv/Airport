package com.runa.airport.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeDeserializer extends StdDeserializer<OffsetDateTime> {

    private static final long serialVersionUID = 1L;

    protected OffsetDateTimeDeserializer() {
        super(OffsetDateTime.class);
    }

    @Override
    public OffsetDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss' 'XXXXX");
        return OffsetDateTime.parse(jp.readValueAs(String.class), format);
    }
}