package com.myshoppingcart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BasketItem {
    private Product product;
    private int amount;
}
