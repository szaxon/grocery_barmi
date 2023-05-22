package com.codecool.groceryshopping.service;

import com.codecool.groceryshopping.model.Cart;
import com.codecool.groceryshopping.model.Category;
import com.codecool.groceryshopping.model.Grocery;
import com.codecool.groceryshopping.model.Product;

import java.io.BufferedReader;
import java.util.Map;

public class ShoppingUI {

    private static final String BUY_COMMAND = "buy";
    private static final String LIST_COMMAND = "list";
    private final BufferedReader br;

    private boolean isRun = true;
    private final Cart cart;

    public ShoppingUI(BufferedReader br, Cart cart) {
        this.br = br;
        this.cart = cart;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public void printProductsOfGroceryInFormat(Grocery grocery) {
        int counter = 1;
        System.out.printf("%S%n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~%n", grocery.name());
        for (Product product : grocery.productList()) {
            System.out.printf("%2d. ", counter);
            System.out.printf("%-28s: ", product.name());
            System.out.printf("%4d : ", product.netPrice());
            StringBuilder categoryForProducts = new StringBuilder();
            for (Category category : product.categories()) {
                categoryForProducts.append(category).append(", ");
            }
            categoryForProducts = new StringBuilder(categoryForProducts.substring(0, categoryForProducts.length() - 2));
            System.out.printf("%s%n", categoryForProducts.toString());
            counter++;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Put an item in your cart or type 'buy' to see the check: ");
    }

    public void run(Grocery grocery) {
        printProductsOfGroceryInFormat(grocery);
        while (isRun) {
            displayCart();
            try {
                String input = br.readLine().strip();
                if (input.equals(LIST_COMMAND)) {
                    printProductsOfGroceryInFormat(grocery);
                } else if (input.equals(BUY_COMMAND)) {
                    System.out.println("Good Bye");
                    setRun(false);
                } else if (0 <= Integer.parseInt(input) && Integer.parseInt(input) <= grocery.productList().size()) {
                    cart.addToCart(grocery.productList().get(Integer.parseInt(input) - 1));
                }
            } catch (Exception e) {
                System.out.println("You've tried to add an invalid product, please try again! Type 'list' to see your options.");
            }
        }
    }

    private void displayCart() {
        if (cart.productsInCart().size() == 0) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart");
            System.out.println("          product           :  quantity  :  net unit  : net total  :  tax rate  : tax total  : gross total");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            int total = 0;
            for (Map.Entry<Product, Integer> entry : cart.productsInCart().entrySet()) {
                System.out.printf("%-28s:", entry.getKey().name());
                System.out.printf("%5d  pcs  :", entry.getValue());
                System.out.printf("%5d coins :", entry.getKey().netPrice());
                System.out.printf("%5d coins :", entry.getKey().netPrice() * entry.getValue());
                System.out.printf("%7d", calculateTaxes(entry.getKey()));
                System.out.printf("%s", "%    :");
                int result = calculateTaxes(entry.getKey()) * entry.getKey().netPrice() * entry.getValue() / 100;
                System.out.printf("%5d coins :", result);
                int result2 = result + (entry.getKey().netPrice() * entry.getValue());
                total += result2;
                System.out.printf("%6d coins%n", result2);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.print("Total price: " + total + " coins\n");
        }
    }

    private int calculateTaxes(Product product) {
        int result = 0;
        for (Category category : product.categories()) {
            result += category.getTaxRate();
        }
        return result;
    }

    /**
     * Use `br.readLine().strip();` to read a "line" from the console input
     *
     * Prompt text: "Put an item in your cart or type 'buy' to see the check: "
     * Error text: "You've tried to add an invalid product, please try again! Type 'list' to see your options."
     */

    /**
     * Pretty printed cart example
     *
     * Your cart
     *           product           :  quantity  :  net unit  : net total  :  tax rate  : tax total  : gross total
     * ----------------------------------------------------------------------------------------------------------
     * "Pampas" T-bone steak       :    6  pcs  : 1500 coins : 9000 coins :     18%    : 1620 coins : 10620 coins
     * "Gnutella" monster box      :    1  pcs  :  300 coins :  300 coins :     25%    :   75 coins :   375 coins
     * "Petito" chips              :    7  pcs  :  200 coins : 1400 coins :     15%    :  210 coins :  1610 coins
     * "White Noise" rice crackers :    5  pcs  :  100 coins :  500 coins :     15%    :   75 coins :   575 coins
     * "Porky Pork" sausage        :    1  pcs  :  300 coins :  300 coins :      3%    :    9 coins :   309 coins
     * ----------------------------------------------------------------------------------------------------------
     * Total price: 13489 coins
     *
     */
}
