package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import za.ac.cput.StringHelper;
import za.ac.cput.domain.Student;

public class StudentFactory {
    public static Student build(String studentId, String email)
    {
        if(studentId ==null ||studentId.isEmpty() )
            throw new IllegalArgumentException("Student Id is required!");
        if( email ==null||email.isEmpty() )
            throw new IllegalArgumentException("Email is required!");
        return new Student.Builder().studentId(studentId)
                .email(email).build();

    }
    public static Student.StudentId buildId(Student student)
    {
        return new Student.StudentId(student.getStudentId());
    }

    public static Student createStudent(String email,String studentId) {
        if (!StringHelper.isValidEmail(email))
        {
            System.out.println("Invalid email");
            return null;
        }
        if (StringHelper.isNullorEmpty(studentId)||StringHelper.isNullorEmpty(email))
            return null;
        return null;
    }
}
