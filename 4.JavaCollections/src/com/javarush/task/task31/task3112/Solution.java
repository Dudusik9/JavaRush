package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:\\Users\\dimad\\Desktop\\Git"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException
    {
        // Проверка существует ли директория
        if (Files.notExists(downloadDirectory)) Files.createDirectories(downloadDirectory);
        // Создание входящего потока
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        //Получение имени файла
        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        Path downloadFile = Paths.get(downloadDirectory.toString() + fileName);
        //Скачивание содержимого во внутренний файл
        Path tempFile = Files.createTempFile("tmp-", ".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        // Перенос файла в пользовательскую директорию
        return Files.move(tempFile, downloadFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
