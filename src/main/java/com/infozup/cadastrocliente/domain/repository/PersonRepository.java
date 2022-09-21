package com.infozup.cadastrocliente.domain.repository;

import com.infozup.cadastrocliente.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
