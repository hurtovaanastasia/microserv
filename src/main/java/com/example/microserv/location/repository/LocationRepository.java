package com.example.microserv.location.repository;

import com.example.microserv.location.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Integer> {
    Optional<Location> findByCity(String city);
}