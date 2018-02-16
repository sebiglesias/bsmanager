package com.bsmanager.controllers;

import com.bsmanager.models.Group;
import com.bsmanager.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Group group) {
        groupRepository.save(group);
    }

    @GetMapping(value = "/{id}")
    public Group read(@PathVariable long id) {
        return groupRepository.findOne(id);
    }

    @PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Group group) {
        groupRepository.save(group);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        groupRepository.delete(id);
    }

    @GetMapping(value = "/name/{name}")
    public List<Group> findByName(@PathVariable String name){
        return groupRepository.findByName(name);
    }

    @GetMapping
    public Iterable<Group> findAll(){
        return groupRepository.findAll();
    }
}
