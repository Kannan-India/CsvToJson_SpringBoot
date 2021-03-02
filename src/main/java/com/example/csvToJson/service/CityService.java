package com.example.csvToJson.service;

import com.example.csvToJson.model.City;
import com.example.csvToJson.repository.CityRepository;
import com.example.csvToJson.validators.ValidateCity;
import com.example.csvToJson.validators.ValidateCities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City addCity(City city){
        ValidateCity validateCity = new ValidateCity(city, cityRepository.findAll(), cityRepository);
        if(validateCity.validate()){
            return city; //based on the null value of id - recognize that the data has been updated not inserted
        }else{
            return cityRepository.save(city); //inserted
        }
    }

    public List<City> addCities(List<City> cities){
        ValidateCities validateCities = new ValidateCities(cityRepository.findAll(), cityRepository);
        cities.forEach(
                city -> {
                    if(validateCities.validate(city)){
                        //update has happened in the validate cities
                    }else{
                        cityRepository.save(city);
                    }
                }
        );
        return cityRepository.findAll();
    }

    public City updateCity(City city){
        return cityRepository.save(city);
    }



    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public Object deleteCities(){
        cityRepository.deleteAll();
        return null;
    }

//    public boolean validateCity(City city, List<City> cities){
//        String cityName = city.getCity(), stateName = city.getState();
//        return  cities.stream().anyMatch(city1 -> {
//                    boolean bool = city1.getCity().equals(cityName) && city1.getState().equals(stateName);
//                    if(bool){
//                        if(!city1.getTier().equalsIgnoreCase(city.getTier())){
//                            city1.setTier(city.getTier());
//                            cityRepository.save(city1);
//                        }
//                        return true;
//                    }else {
//                        return false;
//                    }
//                }
//        );
//    }



//    public boolean validateCities(List<City> cities){
//        List<City> cityList = cityRepository.findAll();
//        cities.forEach(
//                city -> {
//                    city.getCity()
//                }
//        );
//    }





}
