package com.praveen.springboot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.springboot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
