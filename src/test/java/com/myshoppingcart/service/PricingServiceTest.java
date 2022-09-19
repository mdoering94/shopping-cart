package com.myshoppingcart.service;

import com.myshoppingcart.Basket;
import com.myshoppingcart.BasketItem;
import com.myshoppingcart.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PricingServiceTest {

    private static final Product PRODUCT1 = new Product("A0001",12.99);
    private static final Product PRODUCT2 = new Product("A0002", 3.99);

    PricingService service = new PricingService();

    @Test
    void testTotalAmount() {
        Basket basket = new Basket();
        basket.getItems().add(new BasketItem(PRODUCT1,1));
        basket.getItems().add(new BasketItem(PRODUCT2,1));

        double total = service.getTotalPrice(basket);

        assertThat(total).isEqualTo(16.98);
    }

    @Test
    void testGet1FreeDiscount() {
        Basket basket = new Basket();
        basket.getItems().add(new BasketItem(PRODUCT1,1));
        basket.getItems().add(new BasketItem(PRODUCT2,2));

        double total = service.getTotalPriceGet1FreeDiscount(basket, PRODUCT2.getProductId());

        assertThat(total).isEqualTo(16.98);

    }


}
