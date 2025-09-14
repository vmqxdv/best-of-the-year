package org.lessons.java.thymeleaf.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.lessons.java.thymeleaf.best_of_the_year.model.Movie;
import org.lessons.java.thymeleaf.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  // Methods
  private ArrayList<Movie> getBestMovies() {
    ArrayList<Movie> movies = new ArrayList<>();
    movies.add(new Movie(1, "The Godfather"));
    movies.add(new Movie(2, "Inception"));
    movies.add(new Movie(3, "The Matrix"));

    return movies;
  }

  private ArrayList<Song> getBestSongs() {
    ArrayList<Song> songs = new ArrayList<>();
    songs.add(new Song(1, "Bohemian Rhapsody"));
    songs.add(new Song(2, "Imagine"));
    songs.add(new Song(3, "Hey Jude"));

    return songs;
  }

  // Mapping
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("name", "Valerio");

    return "home";
  }

  @GetMapping("/movies")
  public String movies(Model model) {
    ArrayList<Movie> movies = getBestMovies();

    String movieTitles = movies.stream()
        .map(Movie::getTitle)
        .collect(Collectors.joining(", "));
    model.addAttribute("titles", movieTitles);

    return "movies";
  }

  @GetMapping("/songs")
  public String songs(Model model) {
    ArrayList<Song> songs = getBestSongs();

    String songTitles = songs.stream()
        .map(Song::getTitle)
        .collect(Collectors.joining(", "));
    model.addAttribute("titles", songTitles);

    return "songs";
  }
}
