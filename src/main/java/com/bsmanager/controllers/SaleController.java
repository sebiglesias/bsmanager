package com.bsmanager.controllers;

import com.bsmanager.models.Sale;
import com.bsmanager.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleRepository saleRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sale sale) {
        saleRepository.save(sale);
    }

    @GetMapping(value = "/{id}")
    public Sale read(@PathVariable long id) {
        return saleRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Sale sale) {
        saleRepository.save(sale);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        saleRepository.delete(id);
    }

    @GetMapping
    public Iterable<Sale> findAll(){
        return saleRepository.findAll();
    }
}
