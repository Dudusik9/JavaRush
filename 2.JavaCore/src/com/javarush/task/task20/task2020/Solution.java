package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable
    {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex
    {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileOutputStream outputStream = new FileOutputStream("C:\\1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Person person = new Person("Dmitry", "Dudukin", "Russia", Sex.MALE);
        objectOutputStream.writeObject(person);
        outputStream.close();
        objectOutputStream.close();
    }
}
