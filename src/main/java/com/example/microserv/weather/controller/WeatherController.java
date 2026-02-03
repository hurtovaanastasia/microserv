package com.example.microserv.weather.controller;

import com.example.microserv.weather.model.Weather;
import com.example.microserv.weather.repository.WeatherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherRepository watherRepo;

    public WeatherController(WeatherRepository repository) {
        this.watherRepo = repository;
    }

    @GetMapping
    public Optional<Weather> getWeather(
            @RequestParam double lat,
            @RequestParam double lon) {

        return watherRepo.findByLatitudeAndLongitude(lat, lon);
    }

    @PostMapping
    public Weather saveWeather(@RequestBody Weather weather) {
        return watherRepo.save(weather);
    }
}