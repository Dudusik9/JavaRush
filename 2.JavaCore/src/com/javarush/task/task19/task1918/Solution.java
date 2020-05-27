package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.parser.Parser;
//import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fileName));
        String tag = args[0], htmlString = null;

        while (reader.ready())
        {
            htmlString += reader.readLine();
        }
        reader.close();

//        Document xml = Jsoup.parse(htmlString,"", Parser.xmlParser());
//        Elements element = xml.getElementsByTag(tag);
//        for(Element i : element)
//        {
//            System.out.println(i);
//        }
    }
}
