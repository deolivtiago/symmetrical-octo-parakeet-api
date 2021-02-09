package me.olvrti.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.olvrti.api.domain.State;
import me.olvrti.api.repositories.StateRepository;
import me.olvrti.api.services.exceptions.ObjectNotFoundException;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	public State findById(Integer id) {
		Optional<State> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! " + id));
	}
}
