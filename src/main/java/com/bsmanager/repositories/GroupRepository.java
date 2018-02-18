package com.bsmanager.repositories;

import com.bsmanager.models.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findByName(String name);
//    List<Group> findByUserid(Long userId);
}
