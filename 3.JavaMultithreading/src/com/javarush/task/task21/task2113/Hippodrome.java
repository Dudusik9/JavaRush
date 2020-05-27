package com.javarush.task.task21.task2113;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

public class Hippodrome
{
    private List<Horse> horses = null;

    public static Hippodrome game;

    public Hippodrome(List horses)
    {
        this.horses = horses;
    }

    public List<Horse> getHorses() {return horses;}

    public void move()
    {
        for(Horse i : horses)
            i.move();
    }

    public void print()
    {
        for(Horse i : horses)
            i.print();
        for(int i = 0; i < 10; i++)
            System.out.println();
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner()
    {
        Horse horse = null;
        int maxDistance = 0;
        for(Horse i : horses)
        {
            if(i.getDistance() > maxDistance || maxDistance == 0)
            {
                maxDistance = (int)i.getDistance();
                horse = i;
            }
        }
        return horse;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();
        game.printWinner();
    }
}
