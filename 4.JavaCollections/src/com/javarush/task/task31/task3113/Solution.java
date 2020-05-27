package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution
{
    public static int countDirectory = 0, countFile = 0;
    public static long size = 0;
    public static void main(String[] args) throws IOException
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));)
        {
            Path path = Paths.get(reader.readLine());
            // Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
            if (!Files.isDirectory(path))
            {
                System.out.println(path.toAbsolutePath() + " - не папка");
                return;
            }
//            Затем посчитай и выведи следующую информацию:
//            Всего папок - [количество папок в директории и поддиректориях]
//            Всего файлов - [количество файлов в директории и поддиректориях]
//            Общий размер - [общее количество байт, которое хранится в директории]
           /* Files.walkFileTree(path, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
                {
                        countFile++;
                        size += attrs.size();
                        return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
                {
                    countDirectory++;
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + (countDirectory - 1));
            System.out.println("Всего файлов - " + countFile);
            System.out.println("Общий размер - " + size);
            */
            // Вариант через Stream

            long countDirs =  Files.walk(path).filter(Files::isDirectory).count();
            long countFiles =  Files.walk(path).filter(Files::isRegularFile).count();
            long countSizes =  Files.walk(path).filter(Files::isRegularFile).map(Path::toFile).mapToLong(File::length).sum();

            System.out.println("Всего папок-"+(countDirs - 1));
            System.out.println("Всего файлов-"+countFiles);
            System.out.println("Общий размер-"+countSizes);
        }
        catch (Exception e)
        {e.printStackTrace();}
    }
}
