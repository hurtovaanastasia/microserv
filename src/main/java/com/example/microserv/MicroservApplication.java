package com.example.microserv;

import com.example.microserv.location.model.Location;
import com.example.microserv.location.repository.LocationRepository;
import com.example.microserv.person.model.Person;
import com.example.microserv.person.repository.PersonRepository;
import com.example.microserv.weather.model.Weather;
import com.example.microserv.weather.repository.WeatherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroservApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservApplication.class, args);
	}
    @Bean
    CommandLineRunner initData(
            LocationRepository locationRepo,
            PersonRepository personRepo,
            WeatherRepository weatherRepo) {

        return args -> {

            Location city1 = locationRepo.save(
                    new Location("Penza", 53.195, 45.018));

            Location city2 = locationRepo.save(
                    new Location("Bobryjsk",53.145, 29.225));

            personRepo.save(new Person("Ingeborga", "Bobryjsk"));
            personRepo.save(new Person("Natalia", "Penza"));

            weatherRepo.save(new Weather(
                    city1.getLatitude(),
                    city1.getLongitude(),
                    40.3,
                    24,
                    "Cloudy"
            ));

            weatherRepo.save(new Weather(
                    city2.getLatitude(),
                    city2.getLongitude(),
                    70.8,
                    15,
                    "Rainy"
            ));
        };
    }
}
