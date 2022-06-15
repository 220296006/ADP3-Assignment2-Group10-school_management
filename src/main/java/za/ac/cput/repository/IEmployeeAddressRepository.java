package za.ac.cput.repository;
import za.ac.cput.domain.EmployeeAddress;

import java.util.Set;
public interface IEmployeeAddressRepository extends IRepository<EmployeeAddress,String> {
    public Set<EmployeeAddress> getAll();
}
