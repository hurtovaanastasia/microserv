package com.example.microserv.weather.controller;

import com.example.microserv.person.model.Person;
import com.example.microserv.weather.model.Weather;
import com.example.microserv.weather.repository.WeatherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherRepository weatherRepo;

    public WeatherController(WeatherRepository repository) {
        this.weatherRepo = repository;
    }

    @GetMapping
    public Iterable<Weather> getAllWeather() {
        return weatherRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Weather> findById(@PathVariable int id) {
        return weatherRepo.findById(id);
    }

    @PostMapping
    public ResponseEntity<Weather> saveWeather(@RequestBody Weather weather) {
        Weather savedWeather = weatherRepo.save(weather);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWeather);
    }
}