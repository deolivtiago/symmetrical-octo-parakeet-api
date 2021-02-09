package me.olvrti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.olvrti.api.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
