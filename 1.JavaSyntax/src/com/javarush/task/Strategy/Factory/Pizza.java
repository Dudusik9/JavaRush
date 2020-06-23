package com.javarush.task.Strategy.Factory;

import com.javarush.task.Strategy.Additional;

public class Pizza implements Restaurant
{
    public Pizza() {
        System.out.println("The PIZZA was opened");
    }

    @Override
    public void prepare() {
        System.out.println("The PIZZA is preparing...");
    }

    @Override
    public void laying() {
        System.out.println("The PIZZA is laying...");
    }

    @Override
    public void eat() {
        System.out.println("The PIZZA was ate...");
    }
}
