package me.olvrti.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.olvrti.api.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
