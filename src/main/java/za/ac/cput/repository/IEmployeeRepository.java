package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee, String>{

    public Set<Employee> getAll();

}
