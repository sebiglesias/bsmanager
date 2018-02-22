package com.bsmanager.repositories;

import com.bsmanager.models.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SaleRepository extends CrudRepository<Sale, Long> {
}
