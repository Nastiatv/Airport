package com.runa.airport.repository;

import com.runa.airport.model.Cargo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ICargoRepository extends MongoRepository<Cargo, String> {

    Cargo findByFlightId(final String id);

    Set<Cargo> findAllByFlightIdIsIn(final Set<String> ids);
}

