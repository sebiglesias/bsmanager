package com.bsmanager.repositories;

import com.bsmanager.models.sales.OrderDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
}
