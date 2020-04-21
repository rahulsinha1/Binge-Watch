package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Streamer;

import java.util.List;

public interface StreamerDao {
    public List<Streamer> findAllStreamers();
    public void deleteStreamer(int id);

}
