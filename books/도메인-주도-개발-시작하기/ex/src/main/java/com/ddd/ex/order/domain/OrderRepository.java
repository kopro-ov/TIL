package com.ddd.ex.order.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(OrderNo no);
    void save(Order order);

    List<Order> findByOrderId(String orderId, int startRow, int size);

    void delete(Order order);

}
