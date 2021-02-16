package me.olvrti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.olvrti.api.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
