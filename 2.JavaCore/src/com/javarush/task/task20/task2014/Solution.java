package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable
{
    public static void main(String[] args)
    {
        try {
            System.out.println(new Solution(4));
            Solution savedObject = new Solution(-2);

            //сериализация объекта
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Asus\\Desktop\\Дмитрий\\1.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(savedObject);
            fileOutputStream.close();
            objectOutputStream.close();
            //десериализация объекта
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Asus\\Desktop\\Дмитрий\\1.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Solution loadedObject = (Solution) objectInputStream.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature)
    {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
