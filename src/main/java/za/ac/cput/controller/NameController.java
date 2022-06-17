package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Name;
import za.ac.cput.service.service.NameService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("schoolmanagement/name/")
@Slf4j
public class NameController {
    private final NameService nameService;

    @Autowired public NameController(NameService nameService)
    {
        this.nameService=nameService;
    }
    @PostMapping("save")
    public ResponseEntity<Name>save(@Valid @RequestBody Name name)
    {
        log.info("save request:{}",name);
        Name save=nameService.save(name);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{nameId}")
    public ResponseEntity<Name>read(@PathVariable Name.NameId nameId)
    {
        log.info("read request:{}",nameId);
        Name name=this.nameService.read(nameId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(name);
    }
    @DeleteMapping("delete/{nameId}")
    public ResponseEntity<Name> delete(@PathVariable Name name)
    {
        log.info("Read request:{}",name);
        this.nameService.delete(name);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List <Name>>findAll()
    {
        List<Name>nameList=this.nameService.findAll();
        return ResponseEntity.ok(nameList);
    }
}
