package com.codecool.groceryshopping.model;

public enum Category {

    FRUIT(5),
    VEGETABLE(5),
    SNACK(15),
    UNHEALTHY(15),
    BIG_CARBON_FOOTPRINT(10),
    VITAL_FOOD(3),
    MEAT(8),
    DAIRY(10),
    ALCOHOL(20);

    private final int taxRate;

    Category(int taxRate) {
        this.taxRate = taxRate;
    }

    public int getTaxRate() {
        return taxRate;
    }
}
