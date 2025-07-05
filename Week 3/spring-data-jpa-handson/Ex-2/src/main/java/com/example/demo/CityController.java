package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/name")
    public List<City> byName(@RequestParam String name) {
        return cityService.getCitiesByName(name);
    }

    @GetMapping("/start")
    public List<City> byStart(@RequestParam String prefix) {
        return cityService.getCitiesStartingWith(prefix);
    }

    @GetMapping("/pop")
    public List<City> byMinPopulation(@RequestParam int min) {
        return cityService.getCitiesWithMinPopulation(min);
    }

    @GetMapping("/between")
    public List<City> byDate(@RequestParam String start, @RequestParam String end) {
        return cityService.getCitiesEstablishedBetween(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/top")
    public List<City> top3() {
        return cityService.getTop3Cities();
    }

    @GetMapping("/hql")
    public List<City> byHql(@RequestParam String name) {
        return cityService.getCitiesByNameHql(name);
    }

    @GetMapping("/native")
    public List<City> byNative(@RequestParam int pop) {
        return cityService.getCitiesByNativeQuery(pop);
    }
}