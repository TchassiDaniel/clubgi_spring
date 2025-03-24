package org.enspy.clubgi.manga.controllers;

import org.enspy.clubgi.manga.dto.PersonRequestDTO;
import org.enspy.clubgi.manga.models.Person;
import org.enspy.clubgi.manga.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

  private PersonService personService;

  @PostMapping
  public ResponseEntity<Person> register(@RequestBody PersonRequestDTO personRequestDTO) {
    return ResponseEntity.ok(this.personService.register(personRequestDTO));

  }

  @PostMapping("/login")
  public ResponseEntity<Person> login(@RequestBody PersonRequestDTO personRequestDTO) {
    return ResponseEntity.ok(this.personService.login(personRequestDTO.getUsername(), personRequestDTO.getPassword()));
  }
}
