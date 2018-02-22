package com.bsmanager.controllers;

import com.bsmanager.models.productInfo.Measure;
import com.bsmanager.repositories.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measure")
public class MeasureController {
    @Autowired
    MeasureRepository measureRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Measure unit) {
        measureRepository.save(unit);
    }

    @GetMapping(value = "/{id}")
    public Measure read(@PathVariable long id) {
        return measureRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Measure unit) {
        measureRepository.save(unit);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        measureRepository.delete(id);
    }

    @GetMapping
    public Iterable<Measure> findAll(){
        return measureRepository.findAll();
    }
}
