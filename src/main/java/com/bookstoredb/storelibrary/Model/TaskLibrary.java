package com.bookstoredb.storelibrary.Model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class TaskLibrary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column
  private String title;
  @Column
  private String author;
  @Column
  private String genre;
  @Column
  private String description;


  public long getId() {
    return id;
  }

  public long setId(long id) {
    return this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public String setTitle(String title) {
    return this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public String setAuthor(String author) {
    return this.author = author;
  }


  public String getGenre() {
    return genre;
  }

  public String setGenre(String genre) {
    return this.genre = genre;

  }
  public String getDescription() {
    return description;
  }

  public String setDescription(String description) {
    return this.description = description;

  }
}