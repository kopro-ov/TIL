package com.ddd.ex.common.model;

import java.util.Objects;

public class Email {

    private String address;

    protected Email() {

    }

    private Email(String address) {
        this.address = address;
    }

    public static Email of(String address) {
        return new Email(address);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email email)) return false;
        return address != null && address.equals(email.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
