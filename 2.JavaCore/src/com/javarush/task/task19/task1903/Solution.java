package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static Map<String, String> countries = new HashMap<String, String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args)
    {
    }

    public static class IncomeDataAdapter implements Customer, Contact
    {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){this.data = data;}

        @Override
        public String getName(){return data.getContactLastName() + ", " + data.getContactFirstName();}

        @Override
        public String getPhoneNumber()
        {
            Integer number = data.getPhoneNumber();
            String s = number.toString();
            if (s.length() < 10)
            {
                while (s.length() < 10)
                {
                    s = "0" + s;
                }
            }
            return "+" + data.getCountryPhoneCode() + "(" + s.substring(0, 2 + 1)+ ")"
                    + s.substring(3, 5 + 1) + "-" + s.substring(6, 7 + 1) + "-" + s.substring(8, 9 + 1);
        }

        @Override
        public String getCompanyName(){return data.getCompany();}

        @Override
        public  String getCountryName(){return countries.get(data.getCountryCode());}

    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}