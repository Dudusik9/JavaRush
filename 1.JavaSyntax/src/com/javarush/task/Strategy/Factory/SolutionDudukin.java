package com.javarush.task.Strategy.Factory;

public class SolutionDudukin
{
    public static void main(String[] args) {
        Restaurant restaurant = new RestaurantFactory().createRestaurant("Dimaa");
        restaurant.prepare();
        restaurant.laying();
        restaurant.eat();

    }
}
