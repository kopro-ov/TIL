package com.ddd.ex.order.domain;

import java.util.Objects;

public class Order {

    private OrderNo number; // OrderNo가 식별자

    protected Order() {

    }

    private Order(OrderNo number) {
        this.number = number;
    }

    public static Order of(OrderNo number) {
        return new Order(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return number != null && number.equals(order.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
