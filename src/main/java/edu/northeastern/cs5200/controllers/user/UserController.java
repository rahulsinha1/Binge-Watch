package edu.northeastern.cs5200.controllers.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @GetMapping("/api/user/description")
    public UserObject sayUserObject() {
        UserObject user = new UserObject("user", "password");
        return user;
    }


    @CrossOrigin
    @GetMapping("/api/user/insert/{username}/{pass}")
    public UserObject insertUser(@PathVariable("username") String user, @PathVariable("pass") String pass) {
        UserObject userObj = new UserObject(user, pass);
        userRepository.save(userObj);
        return userObj;
    }

    @CrossOrigin
    @GetMapping("/api/users/select/all")
    public List<UserObject> selectAllUserObjects() {
        List<UserObject> users =
                (List<UserObject>) userRepository.findAll();
        return users;
    }


}
