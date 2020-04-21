package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.Streamer;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.StreamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;


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
    @RequestMapping("api/streamers/delete")
    public void deleteStreamer(int id) {
        streamerRepository.deleteById(id);
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/streamers/find")
    public List<Streamer> findStreamerByMovieName(String movieName) {
        return (List<Streamer>)streamerRepository.findStreamerByMovie(movieName);
    }
}
