package com.javarush.task.task19.task1921;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready())
        {
            String s = reader.readLine();
            String[] array = s.split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d M yyyy", Locale.ENGLISH);
            Date birthday = simpleDateFormat.parse(array[array.length - 3].toString() + " " +
                    array[array.length - 2].toString() + " " + array[array.length - 1].toString());
            s = s.substring(0, s.indexOf(array[array.length - 3])).trim();
            System.out.println(s);
            Person person = new Person(s, birthday);
            PEOPLE.add(person);
        }
        reader.close();
    }
}
