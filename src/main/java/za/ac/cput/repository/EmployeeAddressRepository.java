package za.ac.cput.repository;

import za.ac.cput.domain.EmployeeAddress;

import java.util.HashSet;
import java.util.Set;

public class EmployeeAddressRepository implements IEmployeeAddressRepository {

    private static EmployeeAddressRepository repository = null;
    private Set<EmployeeAddress> EmployeeAddressDB = null;

    private EmployeeAddressRepository() {
        EmployeeAddressDB = new HashSet<EmployeeAddress>();
    }

    public static EmployeeAddressRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeAddressRepository();
        }
        return repository;
    }


    @Override
    public EmployeeAddress create(EmployeeAddress employeeAddress) {
        boolean success = EmployeeAddressDB.add(employeeAddress);
        if (!success) {
            return null;
        }
        return employeeAddress;
    }

    @Override
    public EmployeeAddress read(String staffId) {
        EmployeeAddress employeeAddress = EmployeeAddressDB.stream().filter(e -> e.getStaffId().equals(staffId)).findAny().orElse(null);
        return employeeAddress;
    }

    @Override
    public EmployeeAddress update(EmployeeAddress employeeAddress) {
       EmployeeAddress OldStaffId = read(employeeAddress.getStaffId());
       if (OldStaffId != null){
           EmployeeAddressDB.remove(OldStaffId);
           EmployeeAddressDB.add(employeeAddress);
           return employeeAddress;
       }
        return null;
    }

    @Override
    public boolean delete(String staffId) {
        EmployeeAddress EmployToDelete = read(staffId);
        if (EmployToDelete == null) {
            return false;
        }
        EmployeeAddressDB.remove(EmployToDelete);
        return true;
    }

    @Override
    public Set<EmployeeAddress> getAll() {
        return EmployeeAddressDB;
    }
}