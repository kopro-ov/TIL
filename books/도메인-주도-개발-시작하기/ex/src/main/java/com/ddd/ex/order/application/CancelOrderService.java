package com.ddd.ex.order.application;

import com.ddd.ex.order.NoOrderException;
import com.ddd.ex.order.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelOrderService {

    private final OrderRepository orderRepository;
    private final CancelPolicy cancelPolicy;

    public CancelOrderService(OrderRepository orderRepository, CancelPolicy cancelPolicy) {
        this.orderRepository = orderRepository;
        this.cancelPolicy = cancelPolicy;
    }

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(() -> new NoOrderException());

    }

}
