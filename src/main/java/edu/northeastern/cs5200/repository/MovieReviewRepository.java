package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.MovieReview;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieReviewRepository extends CrudRepository<MovieReview,Integer> {
    @Query(value = "select movieReview from MovieReview movieReview where movieReview.criticName = :criticName")
    public List<MovieReview> findmovieReviewsBycriticName(@Param("criticName")String criticName);

    @Query(value = "select movieReview from MovieReview movieReview where movieReview.movieName = :movieName")
    public List<MovieReview> findmovieReviewsByMovie(@Param("movieName")String movieName);
}
