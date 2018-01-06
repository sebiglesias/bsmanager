package com.bsmanager.controllers;

import com.bsmanager.models.productInfo.Brand;
import com.bsmanager.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @RequestMapping(value = "/{id}")
    public Brand read(@PathVariable long id) {
        return brandRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Brand brand) {
        brandRepository.save(brand);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        brandRepository.delete(id);
    }
}
