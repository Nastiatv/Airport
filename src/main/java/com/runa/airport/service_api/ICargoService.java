package com.runa.airport.service_api;

import com.runa.airport.model.Cargo;

import java.util.Set;

public interface ICargoService {
    Cargo findByFlightId(final String id);

    Set<Cargo> findAllByFlightIdIsIn(final Set<String> ids);
}
