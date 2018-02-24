package com.bsmanager.controllers;

import com.bsmanager.models.products.Category;
import com.bsmanager.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @GetMapping(value = "/{id}")
    public Category read(@PathVariable long id) {
        return categoryRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        categoryRepository.delete(id);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }
}
