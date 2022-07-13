package com.ddd.ex.order.domain;

public class Canceller {
    private String memberId;

    protected Canceller() {

    }
    private Canceller(String memberId) {
        this.memberId = memberId;
    }

    public static Canceller of(String memberId) {
        return new Canceller(memberId);
    }

    public String getMemberId() {
        return memberId;
    }
}
