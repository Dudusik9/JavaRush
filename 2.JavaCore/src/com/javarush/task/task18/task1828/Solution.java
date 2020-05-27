package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        if (args.length > 0) {

            BufferedReader reader1 = new BufferedReader(new FileReader(file));
            List<String > list = new ArrayList<>();
            while (reader1.ready()) {
                String s = reader1.readLine();
                list.add(s);
            }
            reader1.close();

            if (args[0].equals("-u"))
            {
                String id = args[1];
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];

                for (String i : list)
                {
                    if (i.startsWith(args[1].trim()))
                    {
                        list.set(list.indexOf(i), String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity));
                    }
                }

                PrintStream printStream = new PrintStream(new FileOutputStream(file));
                for (String i : list)
                {
                    printStream.println(i);
                }
                printStream.close();
            }

            if(args[0].equals("-d"))
            {
                for(String i : list)
                {
                    if (i.startsWith(args[1].trim()))
                        list.remove(i);
                }
                PrintStream printStream = new PrintStream(new FileOutputStream(file));

                for (String i : list)
                {
                    printStream.println(i);
                }
                printStream.close();
            }
        }
    }
}
