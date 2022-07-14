package com.ddd.ex.order.domain;

import com.ddd.ex.common.jpa.MoneyConverter;
import com.ddd.ex.common.model.Money;
import com.ddd.ex.product.domain.ProductId;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class OrderLine {

    @Embedded
    private ProductId productId;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "amounts")
    private Money amounts;

    protected OrderLine() {

    }

    private OrderLine(ProductId productId, Money price, int quantity) {
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    public static OrderLine of(ProductId productId, Money price, int quantity) {
        return new OrderLine(productId, price, quantity);
    }

    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

}
