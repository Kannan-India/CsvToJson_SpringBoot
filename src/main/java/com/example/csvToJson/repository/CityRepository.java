package com.example.csvToJson.repository;

import com.example.csvToJson.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
