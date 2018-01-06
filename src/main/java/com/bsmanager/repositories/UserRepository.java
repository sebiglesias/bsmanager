package com.bsmanager.repositories;

import java.util.List;
import com.bsmanager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Long>{
    List<User> findByName(String lastName);
}