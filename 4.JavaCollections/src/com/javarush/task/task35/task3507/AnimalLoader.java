package com.javarush.task.task35.task3507;



import java.io.*;

public class AnimalLoader extends ClassLoader
{
    private String pathAn;

    public AnimalLoader(ClassLoader parent, String pathAn) {
        super(parent);
        this.pathAn = pathAn;
    }

    private byte[] loadClassDate(String pathAn) throws FileNotFoundException,IOException
    {
        FileInputStream in = new FileInputStream(new File(pathAn));
        byte[]b = new byte[(int)new File(pathAn).length()];
        in.read(b);
        in.close();
        return b;
    }

    public  Class<?> findClass(String className)throws ClassNotFoundException {
        byte[] bytes=null;
        try
        {
            bytes = loadClassDate(pathAn+className+".class");
            return defineClass(null,bytes,0,bytes.length);
        }
        catch (FileNotFoundException e){e.getMessage();
            return super.findClass(className);}
        catch (IOException e){e.getMessage();
            return super.findClass(className);}

    }
}