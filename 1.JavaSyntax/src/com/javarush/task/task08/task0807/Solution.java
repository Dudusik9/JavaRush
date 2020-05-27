package com.javarush.task.task08.task0807;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.ArrayList;
import java.util.LinkedList;

/* 
LinkedList и ArrayList
*/

public class Solution {
    public static Object createArrayList() {
        ArrayList<String> list = new ArrayList<String>();
        return list;
    }

    public static Object createLinkedList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        return linkedList;
    }

    public static void main(String[] args) {

    }
}
