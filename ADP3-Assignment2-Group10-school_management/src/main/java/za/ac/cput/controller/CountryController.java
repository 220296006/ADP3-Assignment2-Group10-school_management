package za.ac.cput.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.service.CountryService;
import java.util.Set;
/* CountryController.java
 * Controller class for the Country Entity
 * @Author: Thabiso Matsaba (220296006)
 * Date: 13 June 2022
 */
@RestController
@RequestMapping("/school_manager/controller/")
@Slf4j
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {

        this.countryService = countryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save( @RequestBody Country country) {
     log.info("Save request: {}", country);
         Country save = countryService.save(country);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id) {
        log.info("Read request:{}", id);
        Country country = this.countryService.read(id);
           //    .orElseThrow(() new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable  String id ) {
        this.countryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("readAll")
    public ResponseEntity<Set<Country>> readAll() {
      Set<Country> countries = this.countryService.readAll();
      return ResponseEntity.ok(countries);
}
}
