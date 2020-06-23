package com.javarush.task.Strategy.Factory;

import com.javarush.task.Strategy.Additional;

public class Suchi implements Restaurant
{
    public Suchi() {
        System.out.println("Restaurant Suchi was opened!");
    }

    @Override
    public void prepare() {
        System.out.println("The SUCHI is preparing...");
    }

    @Override
    public void laying() {
        System.out.println("The SUCHI is laying...");
    }

    @Override
    public void eat() {
        System.out.println("The SUCHI was ate...");
    }
}
