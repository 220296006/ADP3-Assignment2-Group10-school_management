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

    private final Address address= AddressFactory.build("7","bedford","326","Thornton","3698");
    private Address.AddressId addressId=AddressFactory.buildId(this.address);

    @Autowired
    private AddressService addrService;

    @Order(1)
    @Test
    void save() {
        Address create=this.addrService.save(this.address);
        assertAll(
                ()->assertNotNull(create),
                ()->assertEquals(this.address,create)
        );
    }

    @Order(2)
    @Test
    void read() {
        Optional<Address> view=this.addrService.read(this.addressId);
        System.out.println(view);
        assertAll(
                ()->assertTrue(view.isPresent()),
                ()->assertEquals(this.address,view.get())
        );
    }

    @Order(4)
    @Test
    void delete() {
        this.addrService.delete(this.address);
    }

    @Order(5)
    @Test
    void findAll() {
        List<Address> addressList=this.addrService.findAll();
        assertEquals(0,addressList.size());
    }

    @Order(3)
    @Test
    void findByUnitNumber() {
        String unitNumber=this.addressId.getUnitNumber();
        List<Address>addressList=this.addrService.findByUnitNumber(unitNumber);
        System.out.println(addressList);
        assertSame(1,addressList.size());
    }
}