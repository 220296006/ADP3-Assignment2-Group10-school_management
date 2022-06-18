package za.ac.cput.service.service;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress,String> {
    List<EmployeeAddress> readAll();
    void deleteById(String id);
}
