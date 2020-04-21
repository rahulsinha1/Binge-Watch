package edu.northeastern.cs5200.DAO;

import edu.northeastern.cs5200.model.Critic;
import edu.northeastern.cs5200.repository.CriticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Repository
public class CriticDaoImpl implements CriticDao {

    @Autowired
    private CriticRepository criticRepository;

    @Override
    @GetMapping("/api/critics")
    public List<Critic> findAllCritics() {
        return (List<Critic>) criticRepository.findAll();
    }

    @Override
    @RequestMapping("api/critic/find/username")
    public Critic findCriticByUsername(@RequestParam String username) {
        Critic critic = criticRepository.findCriticByUsername(username);
        return critic;
    }

    @Override
    @RequestMapping("api/critic/find/id")
    public Critic findCriticById(@RequestParam int id) {
        return criticRepository.findById(id).get();
    }

    @Override
    @RequestMapping("api/critic/create")
    public Critic createCritic(Critic critic) {
        criticRepository.save(critic);
        return critic;
    }
}
