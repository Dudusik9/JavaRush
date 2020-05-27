package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("D:\\Разное\\JavaRush\\1.txt", null);
            OutputStream outputStream = new FileOutputStream("D:\\Разное\\JavaRush\\1.txt");
            InputStream inputStream = new FileInputStream("D:\\Разное\\JavaRush\\1.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
          
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human
    {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            String isNamePresent = name != null ? "1" : "0";
            writer.write(isNamePresent + "\r\n");
            writer.flush();
            if(name != null)
                writer.write(name + "\r\n");
                writer.flush();

            String isAssetsPresent = assets != null ? "1" : "0";
            writer.write(isAssetsPresent + "\r\n");
            writer.flush();
            if(assets != null)
            {
                for(Asset i : assets)
                {
                    writer.write(i.getName() + "\r\n");
                    writer.flush();
                    Double getPrice = i.getPrice();
                    writer.write(getPrice.toString() + "\r\n");
                    writer.flush();
                }
            }

        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String isNamePresent = reader.readLine();
            if (isNamePresent.equals("1"))
            {
                this.name = reader.readLine();
            }

            String isAssetsPresent = reader.readLine();
            if(isAssetsPresent.equals("1"))
            {
                while(reader.ready())
                {
                    assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine())));
                }
            }
        }
    }
}
