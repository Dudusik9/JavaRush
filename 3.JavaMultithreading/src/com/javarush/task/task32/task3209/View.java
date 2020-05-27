package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class View extends JFrame implements ActionListener
{
    private Controller controller;

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void init()
    {
        initGui();
        addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }

    public void initMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    public void initEditor()
    {
        //Указание типов документов для отображения редактором
        htmlTextPane.setContentType("text/html");
        //Создание нового компонента с ползунком и добавление новой вкладки
        JScrollPane scrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPane);
        //Создание нового компонента с ползунком и добавление новой вкладки
        JScrollPane scrollPane1 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPane1);
        //Задание предпочтительного размера панели вкладок
        tabbedPane.setPreferredSize(new Dimension());
        //Подписка слушателя на панель закладок
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        //Добавление по центру панели контента текущего фрейма панель tabbedPane
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui()
    {
        initMenuBar();
        initEditor();
        pack();
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void selectedTabChanged()
    {
        if(tabbedPane.getSelectedIndex() == 0)
        {
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() == 1)
        {
            plainTextPane.setText(controller.getPlainText());
        }

        resetUndo();
    }

    public UndoListener getUndoListener()
    {
        return undoListener;
    }

    public boolean canUndo()
    {
        return undoManager.canUndo();
    }

    public boolean canRedo()
    {
        return undoManager.canRedo();
    }

    public void undo()
    {
        try {
            undoManager.undo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void redo()
    {
        try {
            undoManager.redo();
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo()
    {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected()
    {
        boolean tmp = false;
        if(tabbedPane.getSelectedIndex() == 0)
            tmp = true;
        return tmp;
    }

    public void selectHtmlTab()
    {
        //Выбираем HTML вкладку
        tabbedPane.setSelectedIndex(0);
        //Сбрасываем все правки
        resetUndo();
    }

    // Получение документа у контроллера и установка в панель редактирования
    public void update()
    {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout()
    {
        JOptionPane.showMessageDialog(getContentPane(), "Something", "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String event = actionEvent.getActionCommand();
        switch (event)
        {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                showAbout();
                break;
            default:
                break;
        }
    }

    public void exit()
    {
        controller.exit();
    }
}

