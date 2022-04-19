package com.greglturnquist.hackingspringboot.reactive.controller;

import com.greglturnquist.hackingspringboot.reactive.domain.Cart;
import com.greglturnquist.hackingspringboot.reactive.domain.CartItem;
import com.greglturnquist.hackingspringboot.reactive.repository.CartRepository;
import com.greglturnquist.hackingspringboot.reactive.repository.ItemRepository;
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
        return cartRepository.findById("My Cart")
                //몽고디비에서 My Cart를 찾아서 없으면 defaultIfEmpty()를 통해 새로 생성해 반환한다.
                .defaultIfEmpty(new Cart("My Cart"))
                //장바구니 데이터를 가져온 후 장바구니에 담겨 있는 상품이 있는지 확인
                .flatMap(cart -> cart.getCartItems().stream()
                        .filter(cartItem -> cartItem.getItem()
                                .getId().equals(id))
                        .findAny()
                        //같은 상품이 있다면 해당 상품의 수량만 증가 시키고 장바구리를 Mono에 담아 반환
                        .map(cartItem -> {
                            cartItem.increment();
                            return Mono.just(cart);
                        })
                        //새로 장바구니에 담은 상품이 장바구니에 담겨 있지 않은 상품이면 장바구니 추가 후 장바구니를 반환
                        .orElseGet(()-> {
                            return itemRepository.findById(id)
                                    .map(item -> new CartItem(item))
                                    .map(cartItem -> {
                                        cart.getCartItems().add(cartItem);
                                        return cart;
                                    });
                        }))
                //업데이트된 장바구니를 몽고디비에 저장
                .flatMap(cart -> cartRepository.save(cart))
                //웹플럭스가 HTTP 요청을 /cart 위치로 리다이렉트
                .thenReturn("redirect:/cart");
    }

}
