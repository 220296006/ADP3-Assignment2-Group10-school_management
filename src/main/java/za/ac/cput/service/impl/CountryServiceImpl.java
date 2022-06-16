package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.service.service.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public Country save(Country country)
    {
        return this.repository.save(country);
    }
    @Override
    public Optional<Country> read(Country.CountryIdentity countryIdentity){return this.repository.findById(countryIdentity);}

    @Override
    public void delete(Country country){this.repository.delete(country);}
    @Override
    public List<Country> findAll(){return this.repository.findAll();}

    /*
    @Override
    public void deleteById(String id)
    {
        Optional<Country>country=read(id);
        if(country.isPresent())delete(country.get());
    }
     */

    @Override
    public List findByCountryId(String countryId)
    {
        return this.repository.findByCountryId(countryId);
    }
}
