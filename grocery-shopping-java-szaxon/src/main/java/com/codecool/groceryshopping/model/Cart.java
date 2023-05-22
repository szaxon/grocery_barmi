package com.codecool.groceryshopping.model;

import java.util.Map;

public record Cart(Map<Product, Integer> productsInCart) {

    public void addToCart(Product product) {
        if (!isItContains(product)) {
            productsInCart.put(product, 1);
        } else {
            int quantity = productsInCart.get(product);
            int updatedQuantity = quantity + 1;
            productsInCart.put(product, updatedQuantity);
        }
    }

    private boolean isItContains(Product product) {
        return productsInCart.containsKey(product);
    }

}
