package com.bsmanager.repositories;

import java.util.List;
import com.bsmanager.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository  extends CrudRepository<User, Long>{
    List<User> findByName(String lastName);
    List<User> findByEmail(String email);
}