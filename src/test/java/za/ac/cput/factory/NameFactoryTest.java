package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    @Test
    void createName() {

        Name name = NameFactory.createName("alex", "dean", "jones");
        assertNotNull(name);
        System.out.println(name.toString());
    }
}