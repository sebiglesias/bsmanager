package com.bsmanager.controllers;

import com.bsmanager.models.productInfo.Unit;
import com.bsmanager.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    UnitRepository unitRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Unit unit) {
        unitRepository.save(unit);
    }

    @RequestMapping(value = "/{id}")
    public Unit read(@PathVariable long id) {
        return unitRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Unit unit) {
        unitRepository.save(unit);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        unitRepository.delete(id);
    }
}
