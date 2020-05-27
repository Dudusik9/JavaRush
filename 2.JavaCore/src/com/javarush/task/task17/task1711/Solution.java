package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH);
    public static DateFormat dateFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
    public static Person person;


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        if (args.length != 0)
            switch (args[0]) {
                case "-c": {
                    synchronized (allPeople){create(args);}
                }
                break;

                case "-u": {
                    synchronized (allPeople) {update(args);}
                }
                break;

                case "-d": {
                    synchronized (allPeople) {delete(args);}
                }
                break;

                case "-i": {
                    synchronized (allPeople){print(args);}
                }
                break;

                default:
                    break;
            }
    }
        public static void create(String[] args)
        {
            for (int i = 1; i < args.length; i += 3)
            {
                try
                {
                    if (args[i + 1].equals("м"))
                    {
                        allPeople.add(Person.createMale(args[i], dateFormat.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                    else
                    {
                        allPeople.add(Person.createFemale(args[i], dateFormat.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                catch(Exception e){}
            }
        }

        public static void update(String[] args)
        {
            for(int i = 1; i < args.length; i += 4)
            {
                try
                {
                    allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDate(dateFormat.parse(args[i + 3]));
                    if (args[i + 2].startsWith("м"))
                        allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                    else
                        allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                }
                catch (Exception e){}
            }

        }
        public static void delete(String[] args)
        {
            for (int i = 1; i < args.length; i++)
            {
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
                allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
            }

        }
        public static void print(String[] args)
        {
            String sex = null;
            for (int i = 1; i < args.length; i++)
            {
                if (allPeople.get(Integer.parseInt(args[i])).getSex() == Sex.MALE)
                    sex = "м";
                else
                    sex = "ж";
                System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " "
                + sex + " " + sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate()));
            }
        }

}
