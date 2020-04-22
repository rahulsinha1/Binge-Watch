package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.MovieReview;

import java.util.List;

public interface MovieReviewDao {
    public MovieReview addRateAndComment(String comment, int grade, String criticName, String movieName);
    public List<MovieReview> findAllMovieReview();
    public List<MovieReview> findMovieReviewForCritic(String criticName);
    public List<MovieReview> findMovieReviewByMovieName(String movieName);

}
