package org.enspy.clubgi.manga.services;

import org.enspy.clubgi.manga.dto.PersonRequestDTO;
import org.enspy.clubgi.manga.models.Person;
import org.enspy.clubgi.manga.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
  private PersonRepository personRepository;

  public Person register(PersonRequestDTO personRequestDTO) {
    Person person = new Person();
    person.setName(personRequestDTO.getName());
    person.setUsername(personRequestDTO.getUsername());
    person.setPassword(personRequestDTO.getPassword());
    return this.personRepository.save(person);
  }

  public Person login(String username, String password) {
    Person person = this.personRepository.findByUsername(username);
    if (person == null)
      return null;

    if (person.getPassword().equals(password))
      return person;
    return null;
  }
}
