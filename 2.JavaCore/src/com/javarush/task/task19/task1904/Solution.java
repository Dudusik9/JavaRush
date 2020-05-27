package com.javarush.task.task19.task1904;

import java.io.*;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution
{

    public static void main(String[] args) throws FileNotFoundException, IOException
    {

        Scanner scan = new Scanner(new FileReader("D:\\1.txt"));
        PersonScannerAdapter test = new PersonScannerAdapter(scan);
        System.out.println(test.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner fileScanner;

        public PersonScannerAdapter (Scanner fileScanner) {this.fileScanner = fileScanner;}

        @Override
        public Person read() throws IOException
        {
            String s = fileScanner.nextLine();
            String[] data = s.split(" ");
            Person person = null;
            try
            {
                DateFormat dateFormat = new SimpleDateFormat("d M yyyy", Locale.ENGLISH);
                Date birthDate = dateFormat.parse(data[3] + " " + data[4] + " " + data[5]);
                person = new Person(data[1], data[2], data[0], birthDate);
            }
            catch (Exception e) {}
            return person;
        }

        @Override
        public void close() throws IOException
        {
            fileScanner.close();
        }
    }
}
