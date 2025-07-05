package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByNameContaining(String name);
    List<City> findByNameStartingWith(String prefix);
    List<City> findByPopulationGreaterThan(int min);
    List<City> findByEstablishedDateBetween(LocalDate start, LocalDate end);
    List<City> findTop3ByOrderByPopulationDesc();

    @Query("SELECT c FROM City c WHERE c.name = :name")
    List<City> findByNameHql(@Param("name") String name);

    @Query(value = "SELECT * FROM city WHERE population > :pop", nativeQuery = true)
    List<City> findByPopulationNative(@Param("pop") int population);
}