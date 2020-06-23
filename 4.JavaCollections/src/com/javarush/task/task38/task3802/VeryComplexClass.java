package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception
    {
        Files.readAllBytes(Paths.get("fsds"));
    }

    public static void main(String[] args) {

    }
}
