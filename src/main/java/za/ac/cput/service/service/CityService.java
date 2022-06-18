package za.ac.cput.service.service;

import za.ac.cput.domain.City;
import za.ac.cput.service.IService;

import java.util.List;

public interface CityService extends IService<City,String> {
    List<City> readAll();
    void deleteById(String id);

    List<City> findCitiesByCountry_CountryId(String CoId);
}
