package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Student student=StudentFactory
                .build("Test-Id","waseem.dollie.wd@gmail.com" );
        System.out.println(student);
        assertNotNull(student);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> StudentFactory.build(null,"waseem.dollie.wd@gmail.com"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Student ID is required!",exceptionMessage);
    }

}