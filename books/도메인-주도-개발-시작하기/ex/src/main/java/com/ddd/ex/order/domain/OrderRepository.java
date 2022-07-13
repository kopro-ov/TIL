package com.ddd.ex.order.domain;

import java.util.List;

public interface OrderRepository {

    Order findById(OrderNo no);
    void save(Order order);

    List<Order> findByOrderId(String orderId, int startRow, int size);

    void delete(Order order);

}
