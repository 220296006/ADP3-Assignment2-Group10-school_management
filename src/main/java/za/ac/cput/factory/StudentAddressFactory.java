package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId, Address address) {

        if (GenericHelper.isNullorEmpty(studentId))
            throw new IllegalArgumentException("Student Id is null or empty");
        if(GenericHelper.addressisNullorEmpty(address))
            throw new IllegalArgumentException("Address is null or empty");

        return new StudentAddress.Builder().setStudentId(studentId)
                                            .setAddress(address)
                                            .build();
    }

}
