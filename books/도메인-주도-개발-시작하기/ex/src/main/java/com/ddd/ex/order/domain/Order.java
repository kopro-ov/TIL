package com.ddd.ex.order.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {

    @EmbeddedId
    private OrderNo number; // OrderNo가 식별자

    @Embedded
    private Orderer orderer;

    protected Order() {

    }

    private Order(OrderNo number, Orderer orderer) {

        this.number = number;
        this.orderer = orderer;

    }

    public static Order of(OrderNo number, Orderer orderer) {

        return new Order(number, orderer);
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

    public Orderer getOrdered() {
        return orderer;
    }

}
