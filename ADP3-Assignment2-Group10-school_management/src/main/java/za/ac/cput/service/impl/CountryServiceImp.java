package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Country;
import za.ac.cput.repository.CountryRepository;
import za.ac.cput.service.CountryService;
import java.util.Set;

@Service
public class CountryServiceImp implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImp(CountryRepository repository){

        this.repository = repository;
    }

    @Override
    public Country save(Country country) {

        return this.repository.save(country);
    }

    @Override
    public Country read(String s) {

        return this.repository.read(s);
    }

    @Override
    public void delete(String s){

        this.repository.delete(s);
    }

    @Override
    public Set<Country> readAll() {

        return this.repository.readAll();
    }
}
