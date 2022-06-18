package za.ac.cput.service.service;

/*Waseem Dollie - 216040566*/

import za.ac.cput.domain.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress,String> {
    List<StudentAddress> readAll();
    void deleteById(String id);

}
