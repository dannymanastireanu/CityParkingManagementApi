package com.goosfraba.controller;

import com.goosfraba.model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
public class CityParkController {

    @Autowired
    private SessionFactory sessionFactory;

    @PostMapping("/city")
    public ResponseEntity<City> createCity(@RequestBody  City city) {
        if(city.getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        if(getCityById(city.getId()).isPresent()) {
            return ResponseEntity.ok(city);
        }

        saveCity(city);
        return ResponseEntity.created(URI.create("/city/" + city.getId())).body(city);
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCityByIdRequest(@PathVariable String id) {
        return getCityById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    private void saveCity(City city) {
        try(Session s = sessionFactory.openSession()) {
            s.beginTransaction();
            s.persist(city);
            s.getTransaction().commit();
        }
    }

    private Optional<City> getCityById(String id) {
        City city;

        try(Session s = sessionFactory.openSession()) {
            s.beginTransaction();
            city = s.find(City.class, id);
            s.getTransaction().commit();
        }

        return Optional.ofNullable(city);
    }
}
