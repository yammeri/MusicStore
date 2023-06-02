package org.example.services;

import org.example.entities.Customer;
import org.example.utils.ConnectionFactory;
import org.example.repositories.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository = new CustomerRepository(new ConnectionFactory());

    public Customer getCustomerById(Long id) {
        return customerRepository.get(id);
    }

    public boolean saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
