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

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Store store) {
        storeRepository.save(store);
    }

    @RequestMapping(value = "/{id}")
    public Store read(@PathVariable long id) {
        return storeRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Store store) {
        storeRepository.save(store);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        storeRepository.delete(id);
    }
}
