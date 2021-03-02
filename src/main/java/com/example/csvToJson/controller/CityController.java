package com.example.csvToJson.controller;

import com.example.csvToJson.model.City;
import com.example.csvToJson.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class CityController {

    @Autowired
    CityService cityService;

    @PostMapping
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

    @PostMapping(value = "/cities")
    public List<City> addCities(@RequestBody List<City> cities){
        return cityService.addCities(cities);
    }

    @GetMapping
    public List<City> getCities(){
        return cityService.getCities();
    }

    @DeleteMapping
    public Object deleteCities(){
        return cityService.deleteCities();
    }
}
