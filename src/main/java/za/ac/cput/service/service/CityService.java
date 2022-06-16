package za.ac.cput.service.service;

import za.ac.cput.domain.City;
import za.ac.cput.service.IService;

import java.util.List;

public interface CityService extends IService<City,City.CityId> {
    List<City> findAll();
    //void deleteById(String id);
    List<City> findById(String id);
}
