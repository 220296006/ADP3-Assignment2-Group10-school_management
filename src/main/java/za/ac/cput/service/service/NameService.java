package za.ac.cput.service.service;

import za.ac.cput.domain.Name;
import za.ac.cput.service.IService;

import java.util.List;

public interface NameService extends IService<Name,Name.NameId> {
    List<Name> findAll();
    //void deleteById(String id);
    List<Name> findByFirstName(String firstName);
}
