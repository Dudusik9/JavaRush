package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // args [0] - C:\Users\dimad\Desktop\Git\result.txt
        // args[1] - C:\Users\dimad\Desktop\Git\test.zip

        // Вычитываем все содержимое из тестового архива
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        // Ключ - имя файла, value - содержимое
        Map<String, ByteArrayOutputStream> mapa = new HashMap<>();
        ZipEntry zipEntry;
        // Получение текущего zipEntry
        while ((zipEntry = zipInputStream.getNextEntry()) != null)
        {
            // Запись содержимого файла в выходной поток
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;
            while((count = zipInputStream.read(buffer)) != -1)
            {
                baos.write(buffer, 0, count);
            }
            // Запись имени и содержимого файла в мапу
            mapa.put(zipEntry.getName(), baos);
            zipInputStream.closeEntry();
        }
        zipInputStream.close();

        // Создаем пишущий поток для архивного файла
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1])))
        {
            // Добавление нового файла к текущему архиву
            Path newPath = Paths.get(args[0]);
            String newPathInArchive = "new/" + newPath.getFileName();

            // Создание zipEntry по новому адресу и добавление в выходной поток
            zipOutputStream.putNextEntry(new ZipEntry(newPathInArchive));
            Files.copy(newPath, zipOutputStream);

            // Перенос существующих файлов
            for(Map.Entry<String, ByteArrayOutputStream> pair : mapa.entrySet())
            {
                // Проверка на существование файла
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(newPath.getFileName())) continue;
                // Создание нового zipEntry(объект) и добавление содержимого в файл из мапы(содержимое объекта)
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }
    }
        catch (Exception e){}


        // КОД КОТОРЫЙ ПРОХОДИТ ВАЛИДАЦИЮ
//        String newFileName = Paths.get(args[0]).getFileName().toString();
//        String newPathInArchive = "new/" + newFileName;
//        ZipEntry entry;
//        Map<String, ByteArrayOutputStream> filesInArchive = new HashMap<>();
//
//        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]));
//        while ((entry = zipIn.getNextEntry()) != null) {
//            if (entry.getName().endsWith(newFileName)) {
//                newPathInArchive = entry.getName();
//            } else {
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                int length = 0;
//                byte[] buffer = new byte[1024];
//                while ((length = zipIn.read(buffer)) != -1) {
//                    baos.write(buffer, 0, length);
//                }
//                filesInArchive.put(entry.getName(), baos);
//            }
//        }
//        zipIn.close();
//
//        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));
//        zipOut.putNextEntry(new ZipEntry(newPathInArchive));
//        Files.copy(Paths.get(args[0]), zipOut);
//        for (Map.Entry<String, ByteArrayOutputStream> pair : filesInArchive.entrySet()) {
//            zipOut.putNextEntry(new ZipEntry(pair.getKey()));
//            pair.getValue().writeTo(zipOut);
//        }
//        zipOut.close();
    }
}
