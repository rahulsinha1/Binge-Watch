package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.CriticList;
import edu.northeastern.cs5200.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CriticListRepository extends CrudRepository<CriticList,Integer> {
    @Query(value = "select criticList from CriticList criticList where criticList.userName = :userName")
    public List<CriticList> findCriticListsByUserName(@Param("userName")String userName);

    @Query(value = "select criticList from CriticList criticList where criticList.movieName = :movieName")
    public List<CriticList> findCriticListsByMovie(@Param("movieName")String movieName);
}
