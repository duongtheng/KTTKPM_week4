package com.example.demoredisspringboot.controller;

import com.example.demoredisspringboot.entity.Customer;
import com.example.demoredisspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    // Inject the CustomerService dependency into class
    @Autowired
    private CustomerService service;

    // to insert new customer data into the Redis database.
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){

        return service.addCustomer(customer);
    }

    // to fetch All the customers from the Redis database
    @GetMapping
    public List<Customer> getListOfCustomers(){

        return service.getAllCustomers();
    }

    // to fetch Customer data using ID from Redis Database
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){

        return service.getCustomerById(id);
    }

    // to update an existing customer in the Redis database using ID.
    @PutMapping("/{id}")
    public Customer
    updateCustomer(@PathVariable int id,
                   @RequestBody Customer newCustomer){

        return service.updateCustomerById(id, newCustomer);
    }

    // to delete an existing customer from the Redis database using ID
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){

        service.deleteCustomerById(id);
        return "Customer Deleted Successfully";
    }
}
