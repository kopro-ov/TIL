package com.ddd.ex.product.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class CategoryId implements Serializable {
    @Column(name = "category_id")
    private Long value;

    protected CategoryId() {
    }

    private CategoryId(Long value) {
        this.value = value;
    }

    public static CategoryId of(Long value) {
        return new CategoryId(value);
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryId that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}