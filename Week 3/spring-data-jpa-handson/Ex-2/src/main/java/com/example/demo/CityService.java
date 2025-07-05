package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getCitiesByName(String name) {
        return cityRepository.findByNameContaining(name);
    }

    public List<City> getCitiesStartingWith(String prefix) {
        return cityRepository.findByNameStartingWith(prefix);
    }

    public List<City> getCitiesWithMinPopulation(int population) {
        return cityRepository.findByPopulationGreaterThan(population);
    }

    public List<City> getCitiesEstablishedBetween(LocalDate start, LocalDate end) {
        return cityRepository.findByEstablishedDateBetween(start, end);
    }

    public List<City> getTop3Cities() {
        return cityRepository.findTop3ByOrderByPopulationDesc();
    }

    public List<City> getCitiesByNameHql(String name) {
        return cityRepository.findByNameHql(name);
    }

    public List<City> getCitiesByNativeQuery(int population) {
        return cityRepository.findByPopulationNative(population);
    }
}