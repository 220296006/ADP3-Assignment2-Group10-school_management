package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.service.service.AddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddressServiceImplTest {

    private final Address address= AddressFactory.build("test-unit-number","test-complex-number","test-street-Number","test-street=Name","1234");
    private Address.AddressId addressId=AddressFactory.buildId(this.address);

    @Autowired
    private AddressService addrService;

    @Test
    @Order(1)
    void save() {
        Address saved=this.addrService.save(this.address);
        assertAll(
                ()->assertNotNull(saved),
                ()->assertEquals(this.address,saved)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<Address> read=this.addrService.read(this.addressId);
        System.out.println(read);
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertEquals(this.address,read.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        this.addrService.delete(this.address);
    }

    @Test
    @Order(5)
    void findAll() {
        List<Address> addressList=this.addrService.findAll();
        assertEquals(0,addressList.size());
    }

    @Test
    @Order(3)
    void findByUnitNumber() {
        String unitNumber=this.addressId.getUnitNumber();
        List<Address>addressList=this.addrService.findByUnitNumber(unitNumber);
        System.out.println(addressList);
        assertSame(1,addressList.size());
    }
}