package com.bsmanager.controllers;

import com.bsmanager.models.products.Product;
import com.bsmanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(value = "/{id}")
    public Product read(@PathVariable long id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        productRepository.delete(id);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }
}
