package edu.northeastern.cs5200.controller;

import edu.northeastern.cs5200.model.Movie;

import java.util.List;

public interface MovieMethodsDao {
    public List<Movie> findAllMovies();
    public Movie findMovie(String name);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
}
