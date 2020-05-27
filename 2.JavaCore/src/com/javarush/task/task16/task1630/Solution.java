package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }
        catch (IOException e){}
    }

    public static void main(String[] args) throws InterruptedException
    {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException
    {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class  ReadFileThread extends Thread implements ReadFileInterface
    {
        String fileName = "";
        String content = "";

        public  void setFileName(String fullName)
        {
            this.fileName = fullName;
        }

        public String getFileContent()
        {
            return content;
        }
        public void run()
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
                while(reader.ready())
                {
                    content = content + reader.readLine() + " ";
                }
                reader.close();
            }
            catch(Exception e){}

        }
    }
}
