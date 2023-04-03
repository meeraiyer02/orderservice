package edu.iu.c322.orderservice.controller;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;

import java.util.*;

import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Order finaCustomerID(@PathVariable int id){
        return repository.findCustomerID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Order customer){
        return repository.create(customer);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Order customer, @PathVariable int id){
        repository.update(customer,id);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }

}


