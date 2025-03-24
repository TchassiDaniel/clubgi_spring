package org.enspy.clubgi.manga.repositories;

import org.enspy.clubgi.manga.models.Manga;
import org.enspy.clubgi.manga.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {
  List<Manga> findByPerson(Person person);
}
