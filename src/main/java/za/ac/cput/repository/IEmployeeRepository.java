package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee, Employee.EmployeeId>{

    public Set<Employee> getAll();

   // @Query("select e.name.firstName from Employee e where e.email = :email")
    //List<String> findByEmail(@Param(value = "email") String email);
}


