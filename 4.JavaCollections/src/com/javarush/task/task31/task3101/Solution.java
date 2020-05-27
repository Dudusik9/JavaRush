package com.javarush.task.task31.task3101;
import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
+ 1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла, который будет содержать результат.
+ 2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
+ 2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
+ 2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
+ 2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
+ 2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.
*/

public class Solution {
    public static void main(String[] args) throws IOException
    {
        List<File> sortedFiles = new ArrayList<>();
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath,allFilesContent);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(allFilesContent)));

        getFiles(path, sortedFiles);

        //сортируем файлы по имени , поэтому передаем компаратор
        Collections.sort(sortedFiles, (o1, o2) -> o1.getName().compareTo(o2.getName()));
//        for (File file : sortedFiles) {
//            System.out.println(file.getName());
//        }
        for (File file:sortedFiles)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.ready())
                writer.write(reader.read());
            writer.write("\n");
            reader.close();
        }
       writer.close();
    }

    public static void getFiles (File file, List<File> list) {
        File[] files = file.listFiles();
        if (files != null)
        {
            for (File a : files)
            {
                if (a.isDirectory())
                {
                    getFiles(a, list);
                }
                else
                    {
                    if (a.length() <= 50)
                        list.add(a);
                    }
            }
        }
    }
}
