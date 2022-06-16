package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.City;
import za.ac.cput.service.impl.CityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @GetMapping("/getall")
    public List<City> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/read/{name}")
    public City getCountry(@PathVariable String name) {
        return cityService.read(name);
    }

    @PostMapping("/create")
    public City create(@RequestBody City city){
        return cityService.save(city);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody City city){
        cityService.delete(city);
    }
    @PutMapping("/update")
    public City update(@RequestBody City city){
        return cityService.update(city);
    }

}
