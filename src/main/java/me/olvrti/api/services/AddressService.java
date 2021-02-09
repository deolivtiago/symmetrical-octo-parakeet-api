package me.olvrti.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.olvrti.api.domain.Address;
import me.olvrti.api.repositories.AddressRepository;
import me.olvrti.api.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	public Address findById(Integer id) {
		Optional<Address> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! " + id));
	}
}
