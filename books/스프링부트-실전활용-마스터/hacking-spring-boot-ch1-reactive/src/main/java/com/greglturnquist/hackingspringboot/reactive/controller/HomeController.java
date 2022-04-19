package com.greglturnquist.hackingspringboot.reactive.controller;

import com.greglturnquist.hackingspringboot.reactive.domain.Cart;
import com.greglturnquist.hackingspringboot.reactive.domain.Item;
import com.greglturnquist.hackingspringboot.reactive.repository.CartRepository;
import com.greglturnquist.hackingspringboot.reactive.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    public HomeController(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }


    @GetMapping
    Mono<String> home() {
        return Mono.just("home");
    }

    @GetMapping("/cart")
    Mono<Rendering> cart() {

        return Mono.just(Rendering.view("cart")
                .modelAttribute("items", itemRepository.findAll())
                .modelAttribute("cart",
                        cartRepository.findById("My cart")
                        .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }

}
