package za.ac.cput.service.impl;

import za.ac.cput.domain.Employee;
import za.ac.cput.service.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
   //also optional? SERVICE?
    private static EmployeeService SERVICE;

    private EmployeeServiceImpl(){
        this.repository = EmployeeRepository.getRepository();
    }

    //declare singleton OPTIONAL?
    public static EmployeeService getService(){
        if(SERVICE == null){
            SERVICE = new EmployeeServiceImpl();
        }
        return SERVICE;
    }



    @Override
    public Employee save(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Employee employee) {
        this.repository.delete(employee);
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
