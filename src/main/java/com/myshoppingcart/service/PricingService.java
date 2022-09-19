package com.myshoppingcart.service;

import com.myshoppingcart.Basket;
import com.myshoppingcart.BasketItem;

public class PricingService {

    /**
     * Returns the total price for a given basket
     * @param basket Basket
     */
    public double getTotalPrice(Basket basket){
        return basket.getItems().stream()
                .mapToDouble(this::getItemPrice)
                .sum();
    }

   public double getTotalPriceGet1FreeDiscount(Basket basket, String productId) {
       return basket.getItems().stream()
               .mapToDouble( item -> {
                   if(item.getProduct().getProductId().equals(productId)) {
                       return getItemPriceGet1FreeDiscount(item);
                   } else  {
                       return getItemPrice(item);
                   }
               })
               .sum();

   }

    private double getItemPriceGet1FreeDiscount(BasketItem item) {
        if(item.getAmount() > 1) {
            return item.getProduct().getPrice() * (item.getAmount() - 1);
        }
        return getItemPrice(item);
    }

    private double getItemPrice(BasketItem item) {
        return item.getProduct().getPrice()* item.getAmount();
    }

}
