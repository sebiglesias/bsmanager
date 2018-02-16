package com.bsmanager.repositories;

import com.bsmanager.models.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findByName(String name);
}
