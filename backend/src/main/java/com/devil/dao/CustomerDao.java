package com.devil.dao;


import com.devil.models.Customer;

public interface CustomerDao {
void registerCustomer(Customer customer);
boolean isEmailUnique(String email);
}
