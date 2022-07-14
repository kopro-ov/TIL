package com.ddd.ex.common.model;

import java.util.Objects;

public class Money {

    private int value;

    protected Money() {

    }
    private Money(int value) {
        this.value = value;
    }

    public static Money of(int value) {
        return new Money(value);
    }


    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Money multiply(int multiplier) {
        return Money.of(value * multiplier);
    }
}
