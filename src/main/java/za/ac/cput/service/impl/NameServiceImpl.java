package za.ac.cput.service.impl;

import za.ac.cput.domain.Name;
import za.ac.cput.repository.NameRepository;
import za.ac.cput.service.service.NameService;

import java.util.List;

public class NameServiceImpl implements NameService {
    public final NameRepository repository;

    public NameServiceImpl(NameRepository repository){
        this.repository = repository;
    }
    @Override
    public Name save(Name name) {
        return this.repository.create(name);
    }

    @Override
    public Name read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Name name) {
        this.repository.delete(name);
    }

    @Override
    public List<Name> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Name> findByfirstName(String firstName) {
        return this.repository.findByFirstName(firstName);
    }
}
