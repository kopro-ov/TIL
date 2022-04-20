package com.greglturnquist.hackingspringboot.reactive.controller;

import com.greglturnquist.hackingspringboot.reactive.domain.Cart;
import com.greglturnquist.hackingspringboot.reactive.domain.CartItem;
import com.greglturnquist.hackingspringboot.reactive.repository.CartRepository;
import com.greglturnquist.hackingspringboot.reactive.repository.ItemRepository;
import com.greglturnquist.hackingspringboot.reactive.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;
    private final CartService cartService;

    @GetMapping("")
    Mono<Rendering> cart() {

        return Mono.just(Rendering.view("cart")
                .modelAttribute("items", itemRepository.findAll())
                .modelAttribute("cart",
                        cartRepository.findById("My Cart")
                                .defaultIfEmpty(new Cart("My Cart")))
                .build());
    }

    @PostMapping("/add/{id}")
    Mono<String> addToCart(@PathVariable String id) {
        return cartService.addToCart("My Cart", id)
                .thenReturn("redirect:/");
    }

}
