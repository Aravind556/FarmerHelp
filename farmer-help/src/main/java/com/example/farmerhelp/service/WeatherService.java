package com.example.farmerhelp.service;

import com.example.farmerhelp.model.WeatherData;
import com.example.farmerhelp.repository.WeatherDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherDataRepository weatherDataRepository;

    public WeatherService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public List<WeatherData> getWeatherForecastForPastWeek() {
        
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        return weatherDataRepository.findByDateBetweenOrderByDateDesc(startDate, endDate);
    }

    // Add method to fetch weather data from an external API and save it to the database
}