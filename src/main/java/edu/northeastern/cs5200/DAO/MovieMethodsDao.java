package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.User;

import java.util.List;

public interface MovieMethodsDao {
    public List<Movie> findAllMovies();
    public Movie findMovie(String name);
    public Movie findMovieById(int id);
    Movie createMovie(Movie movie);
    public void deleteMovie(int id);

    public List<User> getLikedMovie(String movieName);
}
