package me.olvrti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.olvrti.api.domain.PurchaseOrderProduct;

@Repository
public interface PurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct, Integer> {
}
