package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Streamer;
import edu.northeastern.cs5200.repository.StreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Repository
public class StreamerImpl implements StreamerDao {

    @Autowired
    private StreamerRepository streamerRepository;

    @CrossOrigin
    @Override
    @GetMapping("api/streamers")
    public List<Streamer> findAllStreamers() {
        return (List<Streamer>) streamerRepository.findAll();
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/streamers/delete/{id}")
    public void deleteStreamer(@PathVariable int id) {
        streamerRepository.deleteById(id);
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/streamers/find/{movieName}")
    public List<Streamer> findStreamerByMovieName(@PathVariable String movieName) {
        return (List<Streamer>) streamerRepository.findStreamerByMovie(movieName);
    }
}
