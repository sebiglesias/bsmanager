package com.bsmanager.repositories;

import com.bsmanager.models.sales.OrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
    @Query("select od.price, od.product, od.quantity from OrderDetail od inner join od.order o where o.id = :orderId")
    List<Object> getOrderOrderDetail(@Param("orderId") long orderId);
}
