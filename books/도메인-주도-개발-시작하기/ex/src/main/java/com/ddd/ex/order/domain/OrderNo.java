package com.ddd.ex.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderNo implements Serializable {
    @Column(name = "order_number")
    private String number;
    protected OrderNo() {

    }
    private OrderNo(String number) {
        this.number = number;
    }

    public static OrderNo of(String number) {
        return new OrderNo(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderNo orderNo)) return false;
        return number != null && number.equals(orderNo.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
