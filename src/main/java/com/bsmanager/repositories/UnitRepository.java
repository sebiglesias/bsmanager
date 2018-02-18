package com.bsmanager.repositories;

import com.bsmanager.models.productInfo.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UnitRepository extends CrudRepository<Unit, Long> {
}
