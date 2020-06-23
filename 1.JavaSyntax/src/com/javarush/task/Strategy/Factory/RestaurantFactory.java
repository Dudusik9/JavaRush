package com.javarush.task.Strategy.Factory;

public class RestaurantFactory
{
    Restaurant createRestaurant(String name)
    {
        if(name.length() % 2 == 0)
            return new Pizza();
        else
            return new Suchi();
    }
}
