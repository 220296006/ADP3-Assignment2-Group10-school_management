package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import za.ac.cput.domain.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId)
    {
        if(studentId==null || studentId.isEmpty())
            throw new IllegalArgumentException("StudentId is required!");
        return new StudentAddress.Builder().studentId(studentId)
                .build();
    }
    public static StudentAddress.StudentAddressId buildId(StudentAddress studentAddress)
    {
        return new StudentAddress.StudentAddressId(studentAddress.getStudentId());
    }


}
