package com.bsmanager.repositories;

import com.bsmanager.models.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StoreRepository extends CrudRepository<Store, Long> {
//    List<Store> findByUserid(Long userId);
}
