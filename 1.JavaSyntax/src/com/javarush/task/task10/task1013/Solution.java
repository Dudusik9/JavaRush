package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private int age;
        private boolean sex;
        private String country;
        private String nationality;

        public Human(){}
        public Human(String  name)
        {
            this.name = name;
        }
        public Human(int  age)
        {
            this.age = age;
        }
        public Human(boolean sex)
        {
            this.sex = sex;
        }
        public Human(String name, String surname)
        {
            this(name);
            this.surname = surname;
        }
        // пять конструкторов сделано
        public Human(String name, String surname, int age)
        {
            this(name, surname);
            this.age = age;
        }
        public Human(String name, String surname, int age, boolean sex)
        {
            this(name, surname, age);
            this.sex = sex;
        }
        public Human(String name, String surname, int age, boolean sex, String country)
        {
            this(name, surname, age, sex);
            this.country = country;
        }
        public Human(String name, String surname, int age, boolean sex, String country, String nationality)
        {
            this(name, surname, age, sex, country);
            this.nationality = nationality;
        }
        public Human(int age, boolean sex)
        {
            this.age = age;
            this.sex = sex;
        }
    }
}
