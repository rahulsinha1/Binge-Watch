package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends CrudRepository<Movie,Integer> {
    @Query(value = "select movie from Movie movie where movie.name = :name")
    public Movie findFromDB(@Param("name")String name);
}
