package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    final static int MAX_TRUCK_SPEED = 80;
    final static int MAX_SEDAN_SPEED = 120;
    final static int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers)
    {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd)
    {
        if(date.before(summerStart) || date.after(summerEnd))
            return false;
        else
            return true;
    }

    public double getWinterConsumption(int length)
    {
        double consumption;
        return consumption = length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length)
    {
        double consumption;
        return consumption = length * summerFuelConsumption;
    }

    public static Car create (int type, int numberOfPassengers)
    {

        Car car = null;
        if(type == 0)
            car = new Truck(numberOfPassengers);
        else if(type == 1)
            car = new Sedan(numberOfPassengers);
        else if(type == 2)
            car = new Cabriolet(numberOfPassengers);
        return  car;
    }

    public void fill(double numberOfLiters) throws Exception
    {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd)
    {
        double consumption;
        if(isSummer(date, SummerStart, SummerEnd))
            consumption = getSummerConsumption(length);
        else
            consumption = getWinterConsumption(length);
        return consumption;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    private boolean canPassengersBeTransferred()
    {
        if(this.isDriverAvailable() && fuel > 0)
            return true;
        else
            return false;
    }

    public int getNumberOfPassengersCanBeTransferred()
    {
        if(this.canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public void startMoving() {
        if(this.getNumberOfPassengersCanBeTransferred() > 0)
            fastenPassengersBelts();
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

   public abstract int getMaxSpeed();

}