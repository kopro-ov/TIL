package com.ddd.ex.order.domain;

import java.util.Objects;

public class OrderNo {

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
