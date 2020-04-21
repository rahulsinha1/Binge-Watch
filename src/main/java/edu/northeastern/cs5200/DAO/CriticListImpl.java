package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.CriticList;
import edu.northeastern.cs5200.model.Movie;
import edu.northeastern.cs5200.model.User;
import edu.northeastern.cs5200.repository.CriticListRepository;
import edu.northeastern.cs5200.repository.MovieRepository;
import edu.northeastern.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Repository
public class CriticListImpl implements CriticListDao {

    @Autowired
    CriticListRepository criticListRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @CrossOrigin
    @Override
    @RequestMapping("api/critic/addcriticList/{username}/{moviename}")
    public CriticList addRateAndComment(@RequestParam String comment, @RequestParam int grade, @PathVariable("username") String userName, @PathVariable("moviename") String movieName) {
        User user = userRepository.findByUserName(userName);
        Movie movie = movieRepository.findFromDB(movieName);
        CriticList criticList = new CriticList(comment,grade,movieName,userName,movie,user);
        criticListRepository.save(criticList);
        return criticList;
    }

    @CrossOrigin
    @Override
    @GetMapping("api/criticLists")
    public List<CriticList> findAllCriticList() {
        return (List<CriticList>) criticListRepository.findAll();
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/criticList/find/username")
    public List<CriticList> findCriticListForCritic(String userName) {
        return criticListRepository.findCriticListsByUserName(userName);
    }

    @CrossOrigin
    @Override
    @RequestMapping("api/criticList/find/moviename")
    public List<CriticList> findCriticListByMovieName(String movieName) {
        return criticListRepository.findCriticListsByMovie(movieName);
    }
}
