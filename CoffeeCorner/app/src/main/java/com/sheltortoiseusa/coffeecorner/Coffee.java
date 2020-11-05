package com.sheltortoiseusa.coffeecorner;

public class Coffee {
    private Integer quantity;

    Boolean hasWhippingCream;
    Boolean hasChocolate;

    public Coffee() {
        quantity = 0;

        hasWhippingCream = false;
        hasChocolate = false;
    }
    public String getQuantity() {
        return quantity.toString();
    }
    public String getWhippingCream() {
        if(hasWhippingCream == true) {
            return "True";
        }
        else {
            return "False";
        }
    }
    public String getChocolate() {
        if(hasChocolate == true) {
            return "True";
        }
        else {
            return "False";
        }
    }
    public void increment() {
        quantity += 1;
    }
    public void decrement() {
        if(quantity != 0) {
            quantity -= 1;
        }
    }
    public void setHasWhippingCream() {
        if(hasWhippingCream == true) {
            hasWhippingCream = false;
        }
        else {
            hasWhippingCream = true;
        }
    }
    public void setHasChocolate() {
        if(hasChocolate == true) {
            hasChocolate = false;
        }
        else {
            hasChocolate = true;
        }
    }
    public String computeOrder() {
        Double totalCost = (quantity * 4.00);

        if(hasWhippingCream == true) {
            totalCost += (quantity * .50);
        }
        if(hasChocolate == true) {
            totalCost += (quantity * 1.00);
        }
        return totalCost.toString();
    }
}
