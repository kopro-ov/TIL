package com.ddd.ex.order.domain;

import com.ddd.ex.common.jpa.MoneyConverter;
import com.ddd.ex.common.model.Money;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Table(name = "purchase_order")
@Entity
@Access(AccessType.FIELD)
public class Order {

    @EmbeddedId
    private OrderNo number; // OrderNo가 식별자

    @Embedded
    private Orderer orderer;

    @Embedded
    private ShippingInfo shippingInfo;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    protected Order() {

    }

    private Order(OrderNo number, Orderer orderer, ShippingInfo shippingInfo, OrderState orderState) {
        this.number = number;
        this.orderer = orderer;
        this.shippingInfo = shippingInfo;
        this.orderState = orderState;
    }

    public static Order of(OrderNo number, Orderer orderer, ShippingInfo shippingInfo, OrderState orderState) {
        return new Order(number, orderer, shippingInfo, orderState);
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
