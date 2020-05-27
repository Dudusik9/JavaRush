package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int res = 0;

        if(this.age > anotherCat.age)
            res++;
        else if (this.age != anotherCat.age)
            res--;

        if(this.weight > anotherCat.weight)
            res++;
        else if (this.weight != anotherCat.weight)
            res--;

        if (this.strength > anotherCat.strength)
            res++;
        else if (this.strength != anotherCat.strength)
            res--;

        if (res > 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
