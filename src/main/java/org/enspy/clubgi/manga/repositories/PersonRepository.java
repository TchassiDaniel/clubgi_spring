package org.enspy.clubgi.manga.repositories;

import org.enspy.clubgi.manga.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
  Person findByUsername(String username);
}
