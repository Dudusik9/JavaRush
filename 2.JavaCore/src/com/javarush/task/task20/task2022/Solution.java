package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable
{
    transient private FileOutputStream stream;
    private String fileName = null;

    public Solution(String fileName) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
    //    out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {

        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    //    in.close();
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Solution object = new Solution("C:\\Users\\dimad\\Desktop\\JavaRush Project\\1.txt");
        object.writeObject("Test string 1234 !");
        // сериализация
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\dimad\\Desktop\\JavaRush Project\\2.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        outputStream.close();
        // десериализация
        FileInputStream inputStream = new FileInputStream("C:\\Users\\dimad\\Desktop\\JavaRush Project\\2.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Solution object1 = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
    }
}
