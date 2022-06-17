package za.ac.cput.controller;

import com.thoughtworks.qdox.model.expression.Add;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Name;
import za.ac.cput.service.service.AddressService;
import za.ac.cput.service.service.NameService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/address/")
@Slf4j
public class AddressController {
    private final AddressService addressService;

    @Autowired public AddressController(AddressService addressService)
    {
        this.addressService=addressService;
    }
    @PostMapping("save")
    public ResponseEntity<Address>save(@Valid @RequestBody Address address)
    {
        log.info("save request:{}",address);
        Address save=addressService.save(address);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{addressId}")
    public ResponseEntity<Address> read(@PathVariable Address.AddressId addressId)
    {
        log.info("Read request:{}",addressId);
        Address address=this.addressService.read(addressId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(address);
    }
    @DeleteMapping("delete/{addressId}")
    public ResponseEntity<Address>delete(@PathVariable Address address)
    {
        log.info("Read request:{}",addressService);
        this.addressService.delete(address);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Address>>findAll()
    {
        List<Address>addressList=this.addressService.findAll();
        return ResponseEntity.ok(addressList);
    }
}
