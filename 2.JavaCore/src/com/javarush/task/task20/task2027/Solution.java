package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }


    public static String find (int [][] field,int z, int b, int[] ints){

        String matches = "null";

        for(int i = 0; i < ints.length; i++)
        {
            try{
                if (ints[i] == field[z][b+i]){
                    matches = "east";
                }else{
                    matches = "null";
                    break;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                matches = "null";
                break;
            }
        }
        if (matches.equals("east")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z-i][b+i]){
                        matches = "northEast";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("northEast")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z-i][b]){
                        matches = "north";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("north")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z-i][b-i]){
                        matches = "northWest";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("northWest")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z][b-i]){
                        matches = "west";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("west")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z+i][b-i]){
                        matches = "southWest";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("southWest")){return matches;}

        else
            {
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z+i][b]){
                        matches = "south";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("south")){return matches;}

        else{
            for(int i=0; i<ints.length; i++){
                try{
                    if (ints[i] == field[z+i][b+i]){
                        matches = "southEast";
                    }else{
                        matches = "null";
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e) {
                    matches = "null";
                    break;
                }
            }
        }
        if (matches.equals("southEast")){return matches;}

        return "null";
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> list = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            String inputWord = words[i];
            char[] chars = inputWord.toCharArray();
            int[] ints = new int[chars.length];
            for(int j=0; j<chars.length; j++){
                ints[j] = chars[j];
            }

            for(int z = 0; z < crossword.length; z++){

                for(int b = 0; b < crossword[z].length; b++){
                    if (ints[0] == crossword[z][b]){
                        Word word1 = new Word(inputWord);
                        word1.setStartPoint(b, z);

                        if (find(crossword,z,b,ints).equals("east")){
                            word1.setEndPoint(b+ints.length-1, z);
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("northEast")){
                            word1.setEndPoint(b+ints.length-1, z-(ints.length-1));
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("north")){
                            word1.setEndPoint(b, z-(ints.length-1));
                            list.add(word1);
                        }else if(find(crossword,z,b,ints).equals("northWest")){
                            word1.setEndPoint(b-(ints.length-1), z-(ints.length-1));
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("west")){
                            word1.setEndPoint(b-(ints.length-1), z);
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("southWest")){
                            word1.setEndPoint(b-(ints.length-1),z+ints.length-1);
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("south")){
                            word1.setEndPoint(b, z+ints.length-1);
                            list.add(word1);
                        }else if (find(crossword,z,b,ints).equals("southEast")){
                            word1.setEndPoint(b+ints.length-1, z+ints.length-1);
                            list.add(word1);
                        }else{
                            word1.setStartPoint(0,0);
                        }
                    }
                }
            }
        }

        for(Word w : list){
            System.out.println(w);
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
