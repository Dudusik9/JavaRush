package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof Solution) || o == null || this.getClass() != o.getClass())
            return false;
        if (this == o)
            return true;

        Solution n = (Solution) o;
        boolean First = ((n.first.equals(first) && n.last.equals(last)) && first != null);
        boolean Second = false;
        return First && Second;
    }

    public static void main(String[] args)
    {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}