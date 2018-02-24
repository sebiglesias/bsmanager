package com.bsmanager.controllers;

import com.bsmanager.models.products.Brand;
import com.bsmanager.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @GetMapping(value = "/{id}")
    public Brand read(@PathVariable long id) {
        return brandRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        brandRepository.delete(id);
    }

    @GetMapping
    public Iterable<Brand> findAll(){
        return brandRepository.findAll();
    }
}
