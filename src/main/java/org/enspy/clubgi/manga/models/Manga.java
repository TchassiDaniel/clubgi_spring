package org.enspy.clubgi.manga.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manga {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int id;

  private String name;
  private String author;
  @Column(length = 5000) // ou @Lob pour un texte long
  private String description;
  private String url;
  private String imageUrl;

  @OneToOne
  private Person person;
}
