package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller
{
    private View view;
    private HTMLDocument document;
    private File currentFile;


    public Controller (View view)
    {
        this.view = view;
    }

    public void init()
    {
        createNewDocument();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    //Сброс текущего документа
    public void resetDocument()
    {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    //Записывает переданный текст с html тегами в document
    public void setPlainText(String text)
    {
        resetDocument();
        try
        {
            //Вычитывает переданный текст в ридер
            StringReader stringReader = new StringReader(text);
            //записывает переданный текст из ридера в новый документ
            new HTMLEditorKit().read(stringReader, document, 0);
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
    }

    // Метод получает текст из документа с html тегами
    public String getPlainText()
    {
        // Создаем пустой writer
        StringWriter stringWriter = new StringWriter();
        try
        {
            // записываем текст из документа в writer
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        }
        catch (Exception e)
        {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }


    // Создание нового документа
    public void createNewDocument()
    {
        //Выбор html вкладки
        view.selectHtmlTab();
        //Сброс текущего документа
        resetDocument();
        //Новый заголовок окна
        view.setTitle("HTML редактор");
        //Сброс правок в undo менеджере
        view.resetUndo();
        //Обнуление переменной currentFile
        currentFile = null;
    }

    //
    public void openDocument()
    {
        //Выбор html вкладки
        view.selectHtmlTab();
        //Создание нового объекта для выбора файла JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        //Установка ему в качестве фильтра объект HTMLFileFilter
        fileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно Save File для выбора файла
        int result = fileChooser.showOpenDialog(view);
        //
        if(result == JFileChooser.APPROVE_OPTION)
        {
            //Установка нового значения currentFile
            currentFile = fileChooser.getSelectedFile();
            //сброс документа
            resetDocument();
            //Установка имени файла в заголовок представления
            view.setTitle(currentFile.getName());
            //Создание FileReader и чтение данных в документ
            try(FileReader fileReader = new FileReader(currentFile))
            {
                //Записываем переданный текст из fileReader в новый документ
                new HTMLEditorKit().read(fileReader, document, 0);
            }
            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
            view.resetUndo();
        }
    }

    //
    public void saveDocument()
    {
        if(currentFile == null)
            saveDocumentAs();
        else
        {
            //Выбор html вкладки
            view.selectHtmlTab();
            //Создание FileWriter на базе текущего файла и перепись данных из файла в созданный объект
            try( FileWriter fileWriter = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch(Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
    }

    //
    public void saveDocumentAs()
    {
        //Выбор html вкладки
        view.selectHtmlTab();
        //Создание нового объекта для выбора файла JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        //Установка ему в качестве фильтра объект HTMLFileFilter
        fileChooser.setFileFilter(new HTMLFileFilter());
        //Показывать диалоговое окно Save File для выбора файла
        int result = fileChooser.showSaveDialog(view);
        //
        if(result == JFileChooser.APPROVE_OPTION)
        {
            //Сохранение выбранного файла в currentFile
            currentFile = fileChooser.getSelectedFile();
            //Установка имени выбранного файла в качестве окна представления
            view.setTitle(currentFile.getName());
            //Создание FileWriter на базе текущего файла и перепись данных из файла в созданный объект
            try(FileWriter fileWriter = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch(Exception e)
            {
                ExceptionHandler.log(e);
            }
        }

    }

    //
    public void exit()
    {
        System.exit(-1);
    }

    public static void main(String[] args)
    {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }


}
