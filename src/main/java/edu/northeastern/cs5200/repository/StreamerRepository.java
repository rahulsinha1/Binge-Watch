package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.Streamer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StreamerRepository extends CrudRepository<Streamer, Integer> {
    @Query(value = "select streamer from Streamer streamer where streamer.movie=:movie")
    public Streamer findStreamerByMovie(@Param("movie") Movie movie);
}
