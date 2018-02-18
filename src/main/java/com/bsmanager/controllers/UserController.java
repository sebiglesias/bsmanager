package com.bsmanager.controllers;

import com.bsmanager.models.Group;
import com.bsmanager.models.Store;
import com.bsmanager.models.User;
import com.bsmanager.repositories.GroupRepository;
import com.bsmanager.repositories.StoreRepository;
import com.bsmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final StoreRepository storeRepository;

    @Autowired
    public UserController(UserRepository userRepository, GroupRepository groupRepository, StoreRepository storeRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.storeRepository = storeRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping(value = "/{id}")
    public User read(@PathVariable long id) {
        User user = userRepository.findOne(id);
//        List<Group> groups = groupRepository.findByUserid(user.getId());
//        List<Store> stores = storeRepository.findByUserid(user.getId());
//        user.setGroups(new HashSet<>(groups));
//        user.setStores(new HashSet<>(stores));
        return user;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        userRepository.save(user);
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
