package com.javarush.task.task21.task2104;

import javax.swing.text.StyleContext;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object object)
    {
        if (object == null )
            return false;
        if (object.getClass() != this.getClass())
            return false;
        if (!(object instanceof Solution))
            return false;
        if (this == object)
            return true;

        Solution tmp = (Solution)object;
        boolean first = ((tmp.first != null && this.first != null) && (this.first.equals(tmp.first) || this.first == tmp.first)) || (this.first == null && tmp.first == null);
        boolean last = ((tmp.last != null && this.last != null) && (this.last.equals(tmp.last) || this.last == tmp.last)) || (this.last == null && tmp.last == null);
        return first && last;
    }

        @Override
        public int hashCode() {
        int resultFirst = first != null ? first.length() : 0;
        int resultLast = last != null ? last.length() : 0;

        return resultFirst + resultLast;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution("Donald", null)));
        System.out.println(s.contains(new Solution(null, null)));
}
}
