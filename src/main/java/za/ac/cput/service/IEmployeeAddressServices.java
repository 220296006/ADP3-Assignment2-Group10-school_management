package za.ac.cput.service;

import za.ac.cput.domain.EmployeeAddress;

import java.util.Set;

public interface IEmployeeAddressServices extends IServices<EmployeeAddress,String>{
    public Set<EmployeeAddress> getAll();

}
