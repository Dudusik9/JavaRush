package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener
{
    private View view;

    public TextEditMenuListener(View view)
    {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent)
    {
        JMenu jmenu = (JMenu)menuEvent.getSource();
        Component[]  components = jmenu.getMenuComponents();
        for(Component elem : components)
        {
            elem.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}