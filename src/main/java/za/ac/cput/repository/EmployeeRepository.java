/* EmployeeRepository.java
 Employee Repository class
 Author: Zaeem Petersen (219010145)
 Date: 14 June 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Employee;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {

    private static EmployeeRepository repository = null;
    private Set<Employee> employeeDB = null;

    private EmployeeRepository(){
        employeeDB = new HashSet<Employee>();
    }

    //declare singleton
    public static EmployeeRepository getRepository(){
        if(repository == null){
            repository = new EmployeeRepository();
        }
        return repository;
    }

    //CRUD

    @Override
    public Employee save(Employee employee) {
        boolean success = employeeDB.add(employee);

        if(!success){
            return null;
        }
        else
            return employee;
    }

    @Override
    public Optional<Employee> read(Employee.EmployeeId employeeId) {
        return this.repository.read(employeeId);
    }


    @Override
    public void delete(Employee employee) {
    this.employeeDB.remove(employee);
    }

    @Override
    public Set<Employee> getAll() {
        return employeeDB;
    }



}
