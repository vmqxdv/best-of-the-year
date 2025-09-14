package org.lessons.java.thymeleaf.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.lessons.java.thymeleaf.best_of_the_year.model.Identifiable;
import org.lessons.java.thymeleaf.best_of_the_year.model.Movie;
import org.lessons.java.thymeleaf.best_of_the_year.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

  public <T extends Identifiable> T getItemFromId(int id, ArrayList<T> items) {
    for (T item : items) {
      if (item.getId() == id)
        return item;
    }
    return null;
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

  @GetMapping("/movies/{id}")
  public String getMovieFromId(Model model, @PathVariable("id") String movieId) {
    Movie movie = getItemFromId(2, getBestMovies());

    model.addAttribute("movie", movie);

    return "movieById";
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

  @GetMapping("/songs/{id}")
  public String getSongFromId(Model model, @PathVariable("id") String songId) {
    Song song = getItemFromId(2, getBestSongs());

    model.addAttribute("song", song);

    return "songById";
  }

}
