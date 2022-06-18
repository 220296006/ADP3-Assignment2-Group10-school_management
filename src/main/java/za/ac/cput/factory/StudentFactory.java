package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import za.ac.cput.Util.GenericHelper;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;

public class StudentFactory {
    public static Student build(String studentId, String email, Name name) {

        if(GenericHelper.isNullorEmpty(studentId))
            throw new IllegalArgumentException("studentId is null or empty");
        if (!GenericHelper.emailIsValid(email))
            throw new IllegalArgumentException("email is invalid");
        if (GenericHelper.nameisNullorEmpty(name))
            throw new IllegalArgumentException("name is null or empty");

        return new Student.Builder().setStudentId(studentId)
                                    .setEmail(email)
                                    .setName(name)
                                    .build();


    }

    }

