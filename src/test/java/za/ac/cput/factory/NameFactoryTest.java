package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test
    public void buildWithSuccess()
    {
        Name name=NameFactory.build("Zelino","none","Pestana");
        System.out.println(name);
        assertNotNull(name);
    }
    @Test
    void buildwithError()
    {
        Exception exception=assertThrows(IllegalArgumentException.class,()->NameFactory.build(null,"none","Pestana"));
        String exceptionMessage=exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("First Name is required",exceptionMessage);
    }

}

