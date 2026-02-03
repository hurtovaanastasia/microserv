package com.example.microserv.weather.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue
    private int id;

    private double latitude;
    private double longitude;
    private double humidity;
    private double temperature;
    private String description;

    public Weather(double latitude, double longitude, double humidity, double temperature, String description){
        this.latitude = latitude;
        this.longitude = longitude;
        this.humidity = humidity;
        this.temperature = temperature;
        this.description =description;
    }
}