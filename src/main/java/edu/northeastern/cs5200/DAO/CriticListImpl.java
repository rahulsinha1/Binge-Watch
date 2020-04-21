package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Critic;
import edu.northeastern.cs5200.model.CriticList;
import edu.northeastern.cs5200.model.Movie;

import java.util.List;

public class CriticListImpl implements CriticListDao {


    @Override
    public CriticList addCriticList(Critic critic, Movie movie) {
        return null;
    }

    @Override
    public List<CriticList> findAllCriticList() {
        return null;
    }

    @Override
    public List<CriticList> findCriticListForCritic(Critic critic) {
        return null;
    }

    @Override
    public List<CriticList> findCriticListByTitle(String name) {
        return null;
    }
}
