package com.praveen.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.springboot.entity.Customer;
import com.praveen.springboot.service.CustomerService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private CustomerService ser;

	// Get All Customers
	@GetMapping
	public List<Customer> getAllCustomers() {
		return ser.loadAll();
	}

	// Create Customer
	@PostMapping
	public ResponseEntity<Customer> newCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<Customer>(ser.createCustomer(customer), HttpStatus.CREATED);
	}

	// Update Customer
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(name = "id") int id, @RequestBody Customer customer) throws Exception {

		return new ResponseEntity<Customer>(ser.updateCustomer(id, customer), HttpStatus.CREATED);
	}

	// Find Customer By Id
	@GetMapping("{id}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<Customer>(ser.findByid(id), HttpStatus.FOUND);
	}

	// Delete Customer
	@DeleteMapping("{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) throws Exception{
		ser.delById(id);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
}
