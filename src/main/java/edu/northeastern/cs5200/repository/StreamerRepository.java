package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.Streamer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreamerRepository extends CrudRepository<Streamer, Integer> {
    @Query(value = "select streamer from Streamer streamer where streamer.movieName = :movieName")
    public List<Streamer> findStreamerByMovie(@Param("movieName") String movieName);
}
