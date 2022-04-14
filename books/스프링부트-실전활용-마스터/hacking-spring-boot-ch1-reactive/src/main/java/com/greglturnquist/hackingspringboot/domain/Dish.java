package com.greglturnquist.hackingspringboot.domain;

public class Dish {

    private String description;
    private boolean delivered = false;

    public Dish(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Dish deliver(Dish dish) {
        Dish deliveredDish = new Dish(dish.description);
        deliveredDish.delivered = true;
        return deliveredDish;
    }

    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "description='" + description + '\'' +
                ", delivered=" + delivered +
                '}';
    }

}
