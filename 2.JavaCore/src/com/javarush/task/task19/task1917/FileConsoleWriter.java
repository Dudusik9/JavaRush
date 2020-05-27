package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter
{
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }
    //
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        fileWriter.write(cbuf, off, len);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        outputStreamWriter.write(cbuf, off, len);
        outputStreamWriter.close();
    }
    public void write(int c) throws IOException
    {
        fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException
    {
        fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException
    {
        fileWriter.write(str, off, len);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
        outputStreamWriter.write(str, off, len);
        outputStreamWriter.close();
    }
    public void write(char[] cbuf) throws IOException
    {
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }
    public void close() throws IOException
    {
        fileWriter.close();
    }

    public static void main(String[] args)
    {

    }

}
