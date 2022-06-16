package za.ac.cput.service.service;

import za.ac.cput.domain.Name;
import za.ac.cput.service.IService;

import java.util.List;

public interface NameService extends IService<Name, String> {
    //fix add name
    //
    //
    //
    //
    List<Name>findAll();

    List<Name>findByfirstName(String firstName);
}
