package org.enspy.clubgi.manga.services;

import java.util.List;
import java.util.Optional;

import org.enspy.clubgi.manga.dto.MangaRequestDTO;
import org.enspy.clubgi.manga.models.Manga;
import org.enspy.clubgi.manga.models.Person;
import org.enspy.clubgi.manga.repositories.MangaRepository;
import org.enspy.clubgi.manga.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MangaService {
  private MangaRepository mangaRepository;
  private PersonRepository personRepository;

  public Manga save(MangaRequestDTO mangaRequestDTO) {
    Manga manga = new Manga();
    manga.setName(mangaRequestDTO.getName());
    manga.setAuthor(mangaRequestDTO.getAuthor());
    manga.setDescription(mangaRequestDTO.getDescription());
    manga.setUrl(mangaRequestDTO.getUrl());
    manga.setImageUrl(mangaRequestDTO.getImageUrl());

    Optional<Person> optionalPerson = this.personRepository.findById(mangaRequestDTO.getPersonId());

    Person person = optionalPerson.get();
    manga.setPerson(person);
    return this.mangaRepository.save(manga);
  }

  public List<Manga> findAllByPerson(int personId) {
    Optional<Person> optionalPerson = this.personRepository.findById(personId);
    if (optionalPerson.isEmpty())
      return null;

    Person person = optionalPerson.get();
    return this.mangaRepository.findByPerson(person);
  }

  public Manga update(int id, MangaRequestDTO mangaRequestDTO) {
    Optional<Manga> optionalManga = this.mangaRepository.findById(id);
    if (optionalManga.isEmpty())
      return null;

    Manga manga = optionalManga.get();
    manga.setName(mangaRequestDTO.getName());
    manga.setAuthor(mangaRequestDTO.getAuthor());
    manga.setDescription(mangaRequestDTO.getDescription());
    manga.setUrl(mangaRequestDTO.getUrl());
    manga.setImageUrl(mangaRequestDTO.getImageUrl());
    return this.mangaRepository.save(manga);
  }

  public Manga delete(int id) {
    Optional<Manga> optionalManga = this.mangaRepository.findById(id);
    if (optionalManga.isEmpty())
      return null;

    Manga manga = optionalManga.get();
    this.mangaRepository.delete(manga);
    return manga;
  }

  public Manga patchManga(int id, MangaRequestDTO mangaRequestDTO) {
    Optional<Manga> optionalManga = this.mangaRepository.findById(id);
    if (optionalManga.isEmpty())
      return null;

    Manga manga = optionalManga.get();
    if (mangaRequestDTO.getName() != null)
      manga.setName(mangaRequestDTO.getName());
    if (mangaRequestDTO.getAuthor() != null)
      manga.setAuthor(mangaRequestDTO.getAuthor());
    if (mangaRequestDTO.getDescription() != null)
      manga.setDescription(mangaRequestDTO.getDescription());
    if (mangaRequestDTO.getUrl() != null)
      manga.setUrl(mangaRequestDTO.getUrl());
    if (mangaRequestDTO.getImageUrl() != null)
      manga.setImageUrl(mangaRequestDTO.getImageUrl());
    return this.mangaRepository.save(manga);
  }
}
