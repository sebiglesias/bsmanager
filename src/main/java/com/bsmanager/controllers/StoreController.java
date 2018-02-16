package com.bsmanager.controllers;

import com.bsmanager.models.Store;
import com.bsmanager.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreRepository storeRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Store store) {
        storeRepository.save(store);
    }

    @GetMapping(value = "/{id}")
    public Store read(@PathVariable long id) {
        return storeRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Store store) {
        storeRepository.save(store);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        storeRepository.delete(id);
    }

    @GetMapping
    public Iterable<Store> findAll(){
        return storeRepository.findAll();
    }
}
