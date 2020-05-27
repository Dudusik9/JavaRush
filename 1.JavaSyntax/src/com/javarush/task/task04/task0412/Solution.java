package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

//import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a > 0)
            System.out.println(a *= 2);
        else if(a < 0)
            System.out.println(a += 1);
        else
            System.out.println(0);
    }

}