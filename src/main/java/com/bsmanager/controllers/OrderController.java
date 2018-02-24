package com.bsmanager.controllers;

import com.bsmanager.models.sales.Order;
import com.bsmanager.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @GetMapping(value = "/{id}")
    public Order read(@PathVariable long id) {
        return orderRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Order order) {
        orderRepository.save(order);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        orderRepository.delete(id);
    }

    @GetMapping
    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }
}
