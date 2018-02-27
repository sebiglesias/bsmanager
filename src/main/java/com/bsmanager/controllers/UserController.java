package com.bsmanager.controllers;

import com.bsmanager.models.users.User;
import com.bsmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping(value = "/{id}")
    public User read(@PathVariable long id) {
        return userRepository.findOne(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        userRepository.delete(id);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/email", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User findByEmail(@RequestBody String email) {
        final List<User> byEmail = userRepository.findByEmail(email);
        if (!byEmail.isEmpty()) {
            return byEmail.get(0);
        }
        return null;
    }
}
