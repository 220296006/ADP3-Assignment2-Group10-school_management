package za.ac.cput.service;

import za.ac.cput.domain.Name;

import java.util.List;

public interface NameService extends IService<Name, String>{
    //fix add name
    //
    //
    //
    //
    List<Name>findAll();

    List<Name>findByfirstName(String firstName);
}
