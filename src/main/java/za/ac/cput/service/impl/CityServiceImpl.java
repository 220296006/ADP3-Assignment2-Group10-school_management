package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.repository.CityRepository;
import za.ac.cput.service.service.ICityService;


import java.util.List;

@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityRepository repository;

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City read(String name) {
        return repository.findByName(name);
    }

    @Override
    public City update(City city) {
        return repository.save(city);
    }

    @Override
    public void delete(City city) {
        repository.delete(city);
    }

    public List<City> getAll(){
        return repository.findAll();
    }
}
