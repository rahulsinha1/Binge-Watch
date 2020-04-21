package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.CriticList;
import edu.northeastern.cs5200.model.Movie;

import java.util.List;

public interface CriticListDao {
    public CriticList addRateAndComment(String comment, int grade, String userName, String movieName);
    public List<CriticList> findAllCriticList();
    public List<CriticList> findCriticListForCritic(String userName);
    public List<CriticList> findCriticListByMovieName(String movieName);

}
