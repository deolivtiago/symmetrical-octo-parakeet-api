package me.olvrti.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.olvrti.api.domain.PurchaseOrder;
import me.olvrti.api.services.PurchaseOrderService;

@RestController
@RequestMapping(value = "/purchaseorders")
public class PurchaseOrderResource {

	@Autowired
	private PurchaseOrderService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		PurchaseOrder obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}
}
