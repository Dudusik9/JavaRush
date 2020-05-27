package com.javarush.task.task19.task1916;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            reader.close();

            BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));

            List<String> file1 = new ArrayList<>();
            boolean same;
            while(reader1.ready())
            {
                file1.add(reader1.readLine());
            }
            List<String> remain = new ArrayList<>(file1);
            while(reader2.ready())
            {
                same = false;
                String s2 = reader2.readLine();

                for(String s1 : file1)
                {
                    if (s2.equals(s1))
                    {
                        lines.add(new LineItem(Type.SAME, s2));
                        remain.remove(s2);
                        same = true;
                        break;
                    }
                }
                if (!same)
                {
                    lines.add(new LineItem(Type.ADDED, s2));
                    remain.remove(s2);
                }

            }
            int j = 0;
            for(int i = 0; i < lines.size() - 2; i++)
            {
                if (lines.get(i).type.equals(lines.get(i + 1).type))
                    lines.add(lines.indexOf(lines.get(i + 1)), new LineItem(Type.REMOVED, remain.get(j++)));
            }
    //
    //        for (String s1 : remain)
    //        {
    //            lines.add(new LineItem(Type.REMOVED, s1));
    //        }
            //
            for (LineItem pair : lines)
            {
                System.out.println(pair.type.toString() + " " + pair.line.toString());
            }
            reader1.close();
            reader2.close();
    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
