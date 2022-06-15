package za.ac.cput.service;

import za.ac.cput.domain.EmployeeAddress;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeAddressServices extends IServices<EmployeeAddress,String>{
    public List<EmployeeAddress> getAll();

}
