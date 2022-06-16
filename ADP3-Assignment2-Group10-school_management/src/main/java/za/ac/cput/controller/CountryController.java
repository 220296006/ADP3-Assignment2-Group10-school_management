package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.service.CountryService;
import java.util.List;
import java.util.Optional;
/* CountryController.java
 * Controller class for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
@RestController
@RequestMapping("/ADP3-Assignment2-Group10-school_management/controller/")
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {

        this.countryService = countryService;
    }

    private Optional<Country> getById(String id){

        return this.countryService.read(id);
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@Validated @RequestBody Country country) {
     log.info("Save request: {}", country);
         Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Country country = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable  String id) {
       Optional<Country> country = getById(id);
        if (country.isPresent()) {
            this.countryService.delete(country.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Country>> readAll() {
      List<Country> countries = this.countryService.findAll();
      return ResponseEntity.ok(countries);
}
}
