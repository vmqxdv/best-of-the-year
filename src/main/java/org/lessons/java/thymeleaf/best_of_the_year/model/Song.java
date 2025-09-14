package org.lessons.java.thymeleaf.best_of_the_year.model;

public class Song implements Identifiable {
  private int id;
  private String title;

  public Song(int id, String title) {
    this.id = id;
    this.title = title;
  }

  @Override
  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}
