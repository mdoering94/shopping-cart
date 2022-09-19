package com.myshoppingcart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private final String productId;
    private final double price;
}
