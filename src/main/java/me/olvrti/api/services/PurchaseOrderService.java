package me.olvrti.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.olvrti.api.domain.PurchaseOrder;
import me.olvrti.api.repositories.PurchaseOrderRepository;
import me.olvrti.api.services.exceptions.ObjectNotFoundException;

@Service
public class PurchaseOrderService {

	@Autowired
	private PurchaseOrderRepository repository;

	public PurchaseOrder findById(Integer id) {
		Optional<PurchaseOrder> obj = repository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! " + id));
	}
}
