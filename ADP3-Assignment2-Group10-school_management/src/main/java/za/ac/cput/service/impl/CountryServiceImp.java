package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.ICountryRepository;
import za.ac.cput.service.CountryService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
/* CountryServiceImp.java
 * CountryService Implementation class for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 14 June 2022
 */
@Service
public class CountryServiceImp implements CountryService {

    private final ICountryRepository repository;

    public CountryServiceImp(ICountryRepository repository){

        this.repository = repository;
    }

    @Override
    public Country save(Country country) {

        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String id){
        return this.repository.findById(id);
    }

    @Override
    public void delete(Country country){

        this.repository.delete(country);
    }

    @Override
    public List<Country> findAll() {

        return this.repository.findAll();
    }

    @Override
    public List findById(String id) {
        return Collections.singletonList(this.repository.findById(id));
    }
}
