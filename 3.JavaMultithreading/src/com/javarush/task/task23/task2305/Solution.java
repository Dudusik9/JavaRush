package com.javarush.task.task23.task2305;

        import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
        import sun.java2d.pipe.SolidTextRenderer;

/*
Inner
*/
public class Solution
{
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass
    {

    }


    public static Solution[] getTwoSolutions()
    {
        Solution First = new Solution();
        First.innerClasses[0] = First.new InnerClass();
        First.innerClasses[1] = First.new InnerClass();

        Solution Second = new Solution();
        Second.innerClasses[0] = Second.new InnerClass();
        Second.innerClasses[1] = Second.new InnerClass();

        Solution[] array = {First, Second};
        return array;
    }

    public static void main(String[] args)
    {

    }
}
