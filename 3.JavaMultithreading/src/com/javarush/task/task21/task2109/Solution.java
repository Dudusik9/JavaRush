package com.javarush.task.task21.task2109;

import java.io.ObjectInputStream;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable
    {
        private int i;
        private int j;

        public A(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A
    {
        private String name;

        public B(int i, int j, String name)
        {
            super(i, j);
            this.name = name;
        }

        @Override
        public B clone() throws CloneNotSupportedException
        {
            B b = (B) super.clone();
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B
    {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        public C clone() throws CloneNotSupportedException
        {
            C c = new C (this.getI(), this.getJ(), this.getName());
            return c;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        //Проверка программы
        A a = new A (1,1);
        B b = new B (2, 2, "b_original");
        C c = new C (3,3, "c _original");
        System.out.println(a.getI() + " " + a.getJ() + " " + b.getI() + b.getJ() + b.getName() + " "
                + c.getI() + c.getJ() + c.getName());
        C c1 = c.clone();
        System.out.println(c1.getI() + c1.getJ() + c.getName());
    }
}
