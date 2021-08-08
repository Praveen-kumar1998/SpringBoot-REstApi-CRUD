package com.praveen.springboot.service;

import java.util.List;

import com.praveen.springboot.entity.Customer;

public interface CustomerService {

	public List<Customer> loadAll();
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(int id,Customer customer) throws Exception;
	public Customer findByid(int id) throws Exception;
	public void delById(int id) throws Exception;
	
}
