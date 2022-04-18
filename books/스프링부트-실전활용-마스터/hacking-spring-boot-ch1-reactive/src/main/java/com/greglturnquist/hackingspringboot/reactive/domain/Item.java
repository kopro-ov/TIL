package com.greglturnquist.hackingspringboot.reactive.domain;


import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
public class Item {

    private @Id String id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
