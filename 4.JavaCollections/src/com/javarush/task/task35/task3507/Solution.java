package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/*
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> set= new HashSet<>();
        File folder = null;
        Constructor constructor=null;

        String sep = System.getProperty("file.separator");  // получили системный разделитель файлов
        if(!pathToAnimals.endsWith(sep)){                                    // если у передаваемого пути его нет, добавляем
            pathToAnimals=pathToAnimals.concat(sep);
        }

        // получаем полный список файлов .class в указанной директории
        try {
            folder = new File(URLDecoder.decode(pathToAnimals, "UTF-8"));
        }
        catch (UnsupportedEncodingException u){
            u.getStackTrace();}

        String[] files=folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File folder, String name) {
                return name.endsWith(".class");
            }
        });
        // загружаем классы и получаем конструкторы
        try {
            for (int i=0; i<files.length; i++)
            {
                AnimalLoader loader = new AnimalLoader(ClassLoader.getSystemClassLoader(),pathToAnimals);
                Class cl = loader.findClass(files[i].replace(".class",""));      //получили класс

                // получаем список всех конструкторов класса
                Constructor[] constructors = cl.getConstructors();
                boolean isConstructor= false;
                if(constructors.length !=0){
                    for (int j = 0; j <constructors.length ; j++) {
                        if(constructors[j].getParameterTypes().length==0){
                            isConstructor=true;
                            constructor = constructors[j];
                            constructor.setAccessible(true);
                        };
                        break;
                    }
                }
                //проверяем класс на реализацию интерфейса и наличие конструкторы без параметров
                if(isConstructor && Animal.class.isAssignableFrom(cl)){

                    set.add((Animal)constructor.newInstance());
                }
            }
        }

        catch (ClassNotFoundException f){f.getMessage();}
        catch (IllegalAccessException e){e.getMessage();}
        catch (InstantiationException e){e.getMessage();}
        catch (InvocationTargetException e){e.getCause();}

        return set;
    }
}
