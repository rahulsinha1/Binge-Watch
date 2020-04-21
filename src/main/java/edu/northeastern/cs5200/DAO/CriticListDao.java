package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Critic;
import edu.northeastern.cs5200.model.CriticList;
import edu.northeastern.cs5200.model.Movie;

import java.util.List;

public interface CriticListDao {
    public CriticList addCriticList(Critic critic, Movie movie);
    public List<CriticList> findAllCriticList();
    public List<CriticList> findCriticListForCritic(Critic critic);
    public List<CriticList> findCriticListByTitle(String name);
}
