package edu.northeastern.cs5200.repository;

import edu.northeastern.cs5200.model.Critic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CriticRepository extends CrudRepository<Critic,Integer> {
@Query(value = "select critic from Critic critic where critic.username=:username")
    public Critic findCriticByUsername(@Param("username")String username);
}
