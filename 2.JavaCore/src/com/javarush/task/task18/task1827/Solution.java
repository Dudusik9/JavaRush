package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        if (args.length > 0) {

            if (args[0].equals("-c")) {
                BufferedReader reader1 = new BufferedReader(new FileReader(file));
                List<Integer> list = new ArrayList<>();
                while (reader1.ready()) {
                    String s = reader1.readLine();
                    list.add(Integer.parseInt(s.substring(0, 8).trim()));
                }
                reader1.close();
                Collections.sort(list);
                Integer id = list.get(list.size() - 1) + 1;
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];

                PrintStream printStream = new PrintStream(new FileOutputStream(file, true));
                printStream.printf("%n%-8d%-30s%-8s%-4s", id, productName, price, quantity);
                printStream.close();
            }
        }

    }
}
