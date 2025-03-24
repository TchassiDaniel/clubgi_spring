package org.enspy.clubgi.manga.dto;

import lombok.Data;

@Data
public class MangaRequestDTO {
  private String name;
  private String author;
  private String description;
  private String url;
  private String imageUrl;

  private int personId;
}
