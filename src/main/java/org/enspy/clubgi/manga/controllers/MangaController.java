package org.enspy.clubgi.manga.controllers;

import java.util.List;

import org.enspy.clubgi.manga.dto.MangaRequestDTO;
import org.enspy.clubgi.manga.models.Manga;
import org.enspy.clubgi.manga.services.MangaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/manga")
@AllArgsConstructor
public class MangaController {

  private MangaService mangaService;

  @PostMapping
  public ResponseEntity<Manga> save(MangaRequestDTO mangaRequestDTO) {
    return ResponseEntity.ok(this.mangaService.save(mangaRequestDTO));
  }

  @GetMapping("person/{id}")
  public ResponseEntity<List<Manga>> findAllByPerson(@PathVariable int id) {
    return ResponseEntity.ok(this.mangaService.findAllByPerson(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Manga> update(@PathVariable("id") int id, @RequestBody MangaRequestDTO mangaRequestDTO) {
    return ResponseEntity.ok(this.mangaService.update(id, mangaRequestDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Manga> delete(@PathVariable("id") int id) {
    return ResponseEntity.ok(this.mangaService.delete(id));
  }
}
