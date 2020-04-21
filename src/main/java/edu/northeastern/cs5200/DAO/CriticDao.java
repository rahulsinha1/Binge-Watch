package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Critic;
import edu.northeastern.cs5200.model.CriticList;

import java.util.List;

public interface CriticDao {
    public List<Critic> findAllCritics();
    public Critic findCriticByUsername(String username);
    public Critic findCriticById(int id);
    Critic createCritic(Critic critic);

}
