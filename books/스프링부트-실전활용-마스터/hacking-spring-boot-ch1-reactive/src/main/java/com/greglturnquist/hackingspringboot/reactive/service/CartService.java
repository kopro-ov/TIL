package com.greglturnquist.hackingspringboot.reactive.service;

import com.greglturnquist.hackingspringboot.reactive.domain.Cart;
import com.greglturnquist.hackingspringboot.reactive.domain.CartItem;
import com.greglturnquist.hackingspringboot.reactive.repository.CartRepository;
import com.greglturnquist.hackingspringboot.reactive.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;

    public Mono<Cart> findById(String cartId) {
        return cartRepository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId));
    }

    public Mono<Cart> addToCart(String cartId, String id) {
        return cartRepository.findById(cartId)
                .defaultIfEmpty(new Cart(cartId))
                .flatMap(cart -> cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getItem()
                                .getId().equals(id))
                        .findAny()
                        .map(cartItem -> {
                            cartItem.increment();
                            return Mono.just(cart);
                        })
                        .orElseGet(()->
                                itemRepository.findById(id)
                                    .map(CartItem::new)
                                    .doOnNext(cartITem->
                                            cart.getCartItems().add(cartITem))
                                    .map(cartItem -> cart)
                        ))
                .flatMap(cartRepository::save);
    }

}
