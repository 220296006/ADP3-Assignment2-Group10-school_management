package za.ac.cput.service.service;

import za.ac.cput.domain.Employee;
import za.ac.cput.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee,String> {
    List<Employee> readAll();
    void deleteById(String id);
}
