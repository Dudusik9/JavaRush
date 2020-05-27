package com.javarush.task.task25.task2502;

import javafx.scene.chart.ScatterChart;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution
{
    public static enum Wheel
    {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car
    {
        protected List<Wheel> wheels;

        public Car()
        {
            wheels = new ArrayList<>();
            if (loadWheelNamesFromDB().length == 4)
                {
                    for (String i : loadWheelNamesFromDB())
                    {
                        Wheel tmp = Wheel.valueOf(i);
                        if (tmp != null)
                            wheels.add(tmp);

                    }
                }
            else
                throw new IllegalArgumentException();
        }

        protected String[] loadWheelNamesFromDB()
        {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args)
    {
        Car car = new Car();
        System.out.println(car.wheels);
    }
}
