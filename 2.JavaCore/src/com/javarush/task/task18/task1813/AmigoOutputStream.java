package com.javarush.task.task18.task1813;

import sun.text.resources.cldr.ig.FormatData_ig;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "D:\\Разное\\JavaRush\\1.txt";
    private FileOutputStream original;

    public AmigoOutputStream (FileOutputStream original) throws FileNotFoundException
    {
        super(fileName);
        this.original = original;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        original.flush();
        String s = "JavaRush © All rights reserved.";
        original.write(s.getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException
    {
        original.flush();
    }

    @Override
    public FileChannel getChannel() {
        return original.getChannel();
    }

    @Override
    protected void finalize() throws IOException {
        super.finalize();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}
