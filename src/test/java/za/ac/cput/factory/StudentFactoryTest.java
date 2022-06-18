package za.ac.cput.factory;

/*Waseem Dollie - 216040566*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;
import za.ac.cput.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Student student=StudentFactory
                .build("03","randomemail@gmail.com", new Name() );
        System.out.println(student);
        assertNotNull(student);
    }
    @Test
    void buildWithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()-> StudentFactory.build("03","randomemail@gmail.com", null));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("name is required",exceptionMessage);
    }

}
