package edu.northeastern.cs5200.controller;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieMethodsImpl implements MovieMethodsDao{
    @Autowired
    private MovieRepository movieRepository;

    @Override
    @GetMapping("/api/movies")
    public List<Movie> findAllMovies() {
        return(List<Movie>) movieRepository.findAll();
    }

    @Override
    @RequestMapping("/api/movies/find")
    public Movie findMovieByName(@RequestParam String name) {
        Movie movie = movieRepository.findMovieByName(name);
        return movie;
    }

    @Override
    @RequestMapping("/api/movies/add")
    public Movie addMovie(Movie movie) {
        //String name, Date releaseDate, Movie.Region region, Movie.Genre genre,
        movieRepository.save(movie);
        return movie;
    }

    @Override
    @RequestMapping("/api/movies/update")
    public Movie updateMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }


}
