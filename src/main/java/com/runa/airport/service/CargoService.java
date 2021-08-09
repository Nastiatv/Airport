package com.runa.airport.service;

import com.runa.airport.model.Cargo;
import com.runa.airport.repository.ICargoRepository;
import com.runa.airport.service_api.ICargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CargoService implements ICargoService {
    private final ICargoRepository cargoRepository;

    @Override
    public Cargo findByFlightId(String id) {
        return cargoRepository.findByFlightId(id);
    }

    @Override
    public Set<Cargo> findAllByFlightIdIsIn(Set<String> ids) {
        return cargoRepository.findAllByFlightIdIsIn(ids);
    }
}
