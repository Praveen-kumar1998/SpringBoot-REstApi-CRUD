package com.praveen.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.springboot.Dao.CustomerRepo;
import com.praveen.springboot.entity.Customer;
import com.praveen.springboot.exceptions.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo repo;

	
	@Override
	public List<Customer> loadAll() {
		
		return repo.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}


	
	@Override
	public Customer updateCustomer(int id,Customer customer) throws Exception {
		Customer cus=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id ::"+ id));
		
		cus.setName(customer.getName());	
		cus.setPhno(customer.getPhno());
		cus.setEmail(customer.getEmail());
		cus.setPlace(customer.getPlace());
		repo.save(cus);
		
		return cus;
	}

	@Override
	public Customer findByid(int id) throws Exception {
		Customer customer=repo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Customer not found with id ::"+ id));
		return customer;
	}

	@Override
	public void delById(int id) throws Exception {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id ::"+ id));
		repo.deleteById(id);
	}

	

}
