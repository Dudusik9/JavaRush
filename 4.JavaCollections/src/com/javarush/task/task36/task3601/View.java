package com.javarush.task.task36.task3601;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.List;

public class View
{
    Controller controller = new Controller();
    public View() {

    }

    public void fireShowDataEvent() {
        System.out.println(new Controller().onShowDataList());
    }
}
