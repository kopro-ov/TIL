package com.greglturnquist.hackingspringboot.reactive.domain;


import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Item {

    private @Id String id;
    private String name;
    private double price;

}
