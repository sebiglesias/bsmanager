package com.bsmanager.controllers;

import com.bsmanager.models.sales.OrderDetail;
import com.bsmanager.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @GetMapping(value = "/{id}")
    public OrderDetail read(@PathVariable long id) {
        return orderDetailRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        orderDetailRepository.delete(id);
    }

    @GetMapping
    public Iterable<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }

    @GetMapping(value = "/order/{id}")
    public List<Object> getOrderOrderDetail(@PathVariable long id){
        return orderDetailRepository.getOrderOrderDetail(id);
    }
}
