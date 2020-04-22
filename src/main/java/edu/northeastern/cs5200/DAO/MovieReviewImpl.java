package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Critic;
import edu.northeastern.cs5200.model.MovieReview;
import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.repository.CriticRepository;
import edu.northeastern.cs5200.repository.MovieReviewRepository;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Repository
public class MovieReviewImpl implements MovieReviewDao {

    @Autowired
    MovieReviewRepository movieReviewRepository;
    @Autowired
    CriticRepository criticRepository;
    @Autowired
    MovieRepository movieRepository;

    @CrossOrigin
    @Override
    @RequestMapping("api/critic/addmovieReview/{criticname}/{moviename}")
    public MovieReview addRateAndComment(@RequestParam String comment, @RequestParam int grade, @PathVariable("criticname") String criticName, @PathVariable("moviename") String movieName) {
        Critic critic = criticRepository.findByCriticName(criticName);
        Movie movie = movieRepository.findFromDB(movieName);
        MovieReview movieReview = new MovieReview(comment,grade,movieName,criticName,movie,critic);
        movieReviewRepository.save(movieReview);
        return movieReview;
    }

    @CrossOrigin
    @Override
    @GetMapping("api/movieReviews")
    public List<MovieReview> findAllMovieReview() {
        return (List<MovieReview>) movieReviewRepository.findAll();
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/movieReview/find/criticname")
    public List<MovieReview> findMovieReviewForCritic(String criticName) {
        return movieReviewRepository.findmovieReviewsBycriticName(criticName);
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/movieReview/find/moviename")
    public List<MovieReview> findMovieReviewByMovieName(String movieName) {
        return movieReviewRepository.findmovieReviewsByMovie(movieName);
    }
}
