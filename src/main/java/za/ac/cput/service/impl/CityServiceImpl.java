package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.City;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.ICityRepository;
import za.ac.cput.service.service.CityService;

import java.util.List;
import java.util.Optional;
@Service
public class CityServiceImpl implements CityService {
    private final ICityRepository repository;

    @Autowired
    public CityServiceImpl(ICityRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);
    }

    @Override
    public List<City> readAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<City> city = read(id);
        city.ifPresent(this::delete);
    }

}
