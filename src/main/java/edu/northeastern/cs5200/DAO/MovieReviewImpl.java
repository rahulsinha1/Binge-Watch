package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.MovieReview;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.MovieReviewRepository;
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
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @Override
    @PostMapping("api/user/addmovieReview/{username}/{moviename}")
    @CrossOrigin
    public MovieReview addRateAndComment(@RequestParam String comment, @RequestParam int grade, @PathVariable("username") String userName, @PathVariable("moviename") String movieName) {
        User user = userRepository.findByUserName(userName);
        Movie movie = movieRepository.findFromDB(movieName);
        MovieReview movieReview = new MovieReview(comment, grade, movieName, userName, movie, user);
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
    @RequestMapping("api/movieReview/find/user/{username}")
    public List<MovieReview> findMovieReviewForUser(@PathVariable("username") String userName) {
        return movieReviewRepository.findmovieReviewsByuserName(userName);
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/movieReview/find/{movieName}")
    public List<MovieReview> findMovieReviewByMovieName(@PathVariable("movieName") String movieName) {
        return movieReviewRepository.findmovieReviewsByMovie(movieName);
    }
}
