package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException
    {
        List<String> fileList = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>()
        {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
            {
                fileList.add(file.toString());
                return FileVisitResult.CONTINUE;
            }
        });
        for(String file : fileList)
            System.out.println(file);
        return fileList;
    }

    public static void main(String[] args) throws IOException
    {
        getFileTree("C:\\Users\\dimad\\Desktop\\Git");

    }
}
