package com.example.csvToJson.validators;

import com.example.csvToJson.model.City;
import com.example.csvToJson.repository.CityRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidateCities {

    List<City> cities;
    CityRepository cityRepository;
    public ValidateCities(){}

    public ValidateCities(List<City> cities, CityRepository cityRepository){
        this.cities = cities;
        this.cityRepository = cityRepository;
    }

    public boolean validate(City city){
        String cityName = city.getCity(), stateName = city.getState();
        return cities.stream().anyMatch(
                city1 -> {
                    boolean bool = city1.getCity().equalsIgnoreCase(cityName) && city1.getState().equalsIgnoreCase(stateName);
                    if(bool){
                        if(!city1.getTier().equalsIgnoreCase(city.getTier())){
                            city1.setTier(city.getTier());
                            cityRepository.save(city1);
                        }
                        return true;
                    }else{
                        return false;
                    }
                }
        );
    }
}
