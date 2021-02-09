package me.olvrti.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.olvrti.api.domain.Customer;
import me.olvrti.api.repositories.CustomerRepository;
import me.olvrti.api.services.exceptions.ObjectNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer findById(Integer id) {
		Optional<Customer> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! " + id));
	}
}
