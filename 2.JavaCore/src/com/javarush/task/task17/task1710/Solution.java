package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args )
    {
        if (args.length != 0)
            switch (args[0])
            {
                case "-c":
                    {
                        try {
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
                            Person person;
                            if (args[2].equals("м"))
                            {
                                person = Person.createMale(args[1], dateFormat.parse(args[3]));
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                            else
                            {
                                person = Person.createFemale(args[1], dateFormat.parse(args[3]));
                                allPeople.add(person);
                                System.out.println(allPeople.indexOf(person));
                            }
                        }
                        catch (ParseException e){}
                    }
                break;

                case "-u":
                {
                    try
                    {
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
                        Person person;
                        person = allPeople.get(Integer.parseInt(args[1]));

                        person.setName(args[2]);
                        Date date = dateFormat.parse(args[4]);
                        person.setBirthDate(date);
                        if (args[3].startsWith("м"))
                            person.setSex(Sex.MALE);
                        else
                            person.setSex(Sex.FEMALE);
                    }
                    catch (ParseException e){}
                }
                break;

                case "-d":
                {
                    Person person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                }
                break;

                case "-i":
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
                    String sex;
                    if (allPeople.get(Integer.parseInt(args[1])).getSex() == Sex.MALE)
                        sex = "м";
                    else
                        sex = "ж";
                    System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " "
                    + sex + " "
                    + dateFormat.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                }
                break;

                default:
                    break;
            }

        }
}
