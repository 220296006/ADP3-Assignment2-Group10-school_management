package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.City;
import za.ac.cput.service.service.CityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/city/")
@Slf4j
public class CityController {
    private final CityService cityService;

    @Autowired public CityController(CityService cityService)
    {
        this.cityService=cityService;
    }
    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city)
    {
        log.info("save request:{}",city);
        City save=cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{cityId}")
    public ResponseEntity<City> read(@PathVariable City.CityId cityId)
    {
        log.info("Read request:{}",cityId);
        City student=this.cityService.read(cityId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("delete/{cityId}")
    public ResponseEntity<City>delete(@PathVariable City city)
    {
        log.info("Read request:{}",city);
        this.cityService.delete(city);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<City>>findAll()
    {
        List<City>cityList=this.cityService.findAll();
        return ResponseEntity.ok(cityList);
    }
}