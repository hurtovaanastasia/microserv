package com.example.microserv.location.controller;

import com.example.microserv.location.model.Location;
import com.example.microserv.location.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationRepository locationRepo;

    public LocationController(LocationRepository repository) {
        this.locationRepo = repository;
    }

    @GetMapping("/city/{city}")
    public Optional<Location> findByCity(@PathVariable String city) {
        return locationRepo.findByCity(city);
    }

    @PostMapping
    public Location save(@RequestBody Location location) {
        return locationRepo.save(location);
    }
}