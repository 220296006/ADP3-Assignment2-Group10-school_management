package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.service.service.CountryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/country/")
@Slf4j
public class CountryController {
    private final CountryService countryService;

    @Autowired public CountryController(CountryService countryService)
    {
        this.countryService=countryService;
    }
    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country)
    {
        log.info("save request:{}",country);
        Country save=countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{countryId}")
    public ResponseEntity<Country> read(@PathVariable Country.CountryIdentity countryIdentity)
    {
        log.info("Read request:{}",countryIdentity);
        Country student=this.countryService.read(countryIdentity)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("delete/{countryId}")
    public ResponseEntity<Country>delete(@PathVariable Country country)
    {
        log.info("Read request:{}",country);
        this.countryService.delete(country);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Country>>findAll()
    {
        List<Country>countryList=this.countryService.findAll();
        return ResponseEntity.ok(countryList);
    }
}
