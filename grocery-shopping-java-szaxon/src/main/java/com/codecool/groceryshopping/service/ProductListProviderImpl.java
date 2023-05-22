package com.codecool.groceryshopping.service;

import com.codecool.groceryshopping.model.Category;
import com.codecool.groceryshopping.model.Product;

import java.util.*;

public class ProductListProviderImpl {

    private final List<Product> productList;

    public ProductListProviderImpl() {
        this.productList = new LinkedList<>();
        createProductList();
    }

    public List<Product> getProductList() {
        return productList;
    }

    private void createProductList() {
        productList.add(new Product("\"You can bake it!\" flour", 100, new HashSet<>(List.of(Category.VITAL_FOOD))));
        productList.add(new Product("\"Creamy Way\" fat milk", 100, new HashSet<>(List.of(Category.DAIRY))));
        productList.add(new Product("\"Greenade\" avocado", 200, new HashSet<>(List.of(Category.VEGETABLE))));
        productList.add(new Product("\"Sunset\" pineapple", 250, new HashSet<>(List.of(Category.FRUIT, Category.BIG_CARBON_FOOTPRINT))));
        productList.add(new Product("\"Porky Pork\" sausage", 300, new HashSet<>(List.of(Category.VITAL_FOOD))));
        productList.add(new Product("\"Pampas\" T-bone steak", 1500, new HashSet<>(List.of(Category.MEAT, Category.BIG_CARBON_FOOTPRINT))));
        productList.add(new Product("\"White Noise\" rice crackers", 100, new HashSet<>(List.of(Category.SNACK))));
        productList.add(new Product("\"Petito\" chips", 200, new HashSet<>(List.of(Category.SNACK))));
        productList.add(new Product("\"Gnutella\" monster box", 300, new HashSet<>(List.of(Category.DAIRY, Category.UNHEALTHY))));
        productList.add(new Product("\"Silencer\" Gin ", 800, new HashSet<>(List.of(Category.UNHEALTHY, Category.ALCOHOL))));
    }
}
