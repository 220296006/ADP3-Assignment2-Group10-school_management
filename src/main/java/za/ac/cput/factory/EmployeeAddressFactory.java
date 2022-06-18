package za.ac.cput.factory;

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.EmployeeAddress;

public class EmployeeAddressFactory {
    public static EmployeeAddress build(String staffId, Address address)
    {
        if(GenericHelper.isNullorEmpty(staffId))
            throw new IllegalArgumentException("staff id is null or empty");
        if(GenericHelper.addressisNullorEmpty(address))
            throw new IllegalArgumentException("address is null or empty");

        return new EmployeeAddress.Builder().setStaffId(staffId)
                                            .setAddress(address)
                                            .build();
    }

}
