package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args)
    {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person
    {
        public String name;

        Person(String name)
        {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            USD usd = new USD(100);
            Hrivna hrivna = new Hrivna(500);
            Ruble rub = new Ruble(1000);
            allMoney.add(usd);
            allMoney.add(hrivna);
            allMoney.add(rub);
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
