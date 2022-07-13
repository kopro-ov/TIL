package com.ddd.ex.order.domain;

import com.ddd.ex.member.domain.MemberId;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;

    public void setMemberId(MemberId memberId) {
        this.memberId = memberId;
    }

    protected Orderer() {
    }

    private Orderer(MemberId memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public static Orderer of(MemberId memberId, String name) {
        return new Orderer(memberId, name);
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderer orderer = (Orderer) o;
        return Objects.equals(memberId, orderer.memberId) &&
                Objects.equals(name, orderer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, name);
    }
}
