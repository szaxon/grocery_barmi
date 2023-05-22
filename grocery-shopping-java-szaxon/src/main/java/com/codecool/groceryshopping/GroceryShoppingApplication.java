package com.codecool.groceryshopping;

import com.codecool.groceryshopping.model.Cart;
import com.codecool.groceryshopping.model.Grocery;
import com.codecool.groceryshopping.service.ProductListProviderImpl;
import com.codecool.groceryshopping.service.ShoppingUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GroceryShoppingApplication {

    /**
     * Place these products into a Grocery object named "Corner Shop"
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * "You can bake it!" flour    :  100 : VITAL_FOOD
     * "Creamy Way" fat milk       :  100 : DAIRY
     * "Greenade" avocado          :  200 : VEGETABLE
     * "Sunset" pineapple          :  250 : FRUIT, BIG_CARBON_FOOTPRINT
     * "Porky Pork" sausage        :  300 : VITAL_FOOD
     * "Pampas" T-bone steak       : 1500 : MEAT, BIG_CARBON_FOOTPRINT
     * "White Noise" rice crackers :  100 : SNACK
     * "Petito" chips              :  200 : SNACK
     * "Gnutella" monster box      :  300 : DAIRY, UNHEALTHY
     * "Silencer" Gin              :  800 : UNHEALTHY, ALCOHOL
     */
    public static void main(String[] args) {

        Cart cart = new Cart(new HashMap<>());
        ShoppingUI shoppingUI = new ShoppingUI(new BufferedReader(new InputStreamReader(System.in)), cart);
        ProductListProviderImpl productListProvider = new ProductListProviderImpl();
        Grocery grocery = new Grocery("Corner Shop", productListProvider.getProductList());

        shoppingUI.run(grocery);


    }

}
