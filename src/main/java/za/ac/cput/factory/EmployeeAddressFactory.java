package za.ac.cput.factory;

import za.ac.cput.domain.EmployeeAddress;
import za.ac.cput.util.IlyaasHelper;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId)
    {
        if(staffId==null || staffId.isEmpty())
            throw new IllegalArgumentException("staffId is required");
        return new EmployeeAddress.Builder().staffId(staffId)
                .build();
    }
    public static EmployeeAddress.EmployeeAddressId buildId(EmployeeAddress employeeAddress)
    {
        return new EmployeeAddress.EmployeeAddressId(employeeAddress.getStaffId());
    }


}
