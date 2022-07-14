package com.ddd.ex.order.domain;

public class Receiver {

    private String name;
    private String phone;

    protected Receiver() { }

    private Receiver(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public static Receiver of(String name, String phone) {
        return new Receiver(name, phone);
    }

}
