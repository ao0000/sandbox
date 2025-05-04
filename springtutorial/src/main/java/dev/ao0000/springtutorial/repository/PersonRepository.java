package dev.ao0000.springtutorial.repository;

import dev.ao0000.springtutorial.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Optional<Person> findById(Long name);
}
