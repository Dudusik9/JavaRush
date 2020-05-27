package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution
{
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws IOException, Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception
    {
        Properties propert = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            propert.setProperty(pair.getKey(), pair.getValue());
        }
        propert.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception
    {
        Properties propert = new Properties();
        propert.load(inputStream);
        for (Map.Entry pair : propert.entrySet())
        {
            properties.put((String)pair.getKey(), (String)pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception
    {
        Solution example = new Solution();
        example.fillInPropertiesMap();
        OutputStream outputStream = new FileOutputStream("C:\\Users\\Asus\\Desktop\\Дмитрий\\2.txt");
        example.save(outputStream);
        outputStream.close();

    }
}
