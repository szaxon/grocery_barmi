package com.codecool.groceryshopping.model;

import java.util.Set;

public record Product(String name, int netPrice, Set<Category> categories) {

}
