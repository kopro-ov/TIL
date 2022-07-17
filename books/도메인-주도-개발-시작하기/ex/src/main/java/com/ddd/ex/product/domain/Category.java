package com.ddd.ex.product.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
    @EmbeddedId
    private CategoryId id;

    @Column(name = "name")
    private String name;

    protected Category() {
    }

    private Category(CategoryId id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category of(CategoryId id, String name) {
        return new Category(id, name);
    }

    public CategoryId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}