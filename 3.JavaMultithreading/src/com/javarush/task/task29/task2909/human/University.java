package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University
{

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade)
    {
        //TODO:
        Student tmp = null;

        for(Student student : students)
        {
            if(student.getAverageGrade() == averageGrade || tmp == null)
            {
                tmp = student;
            }
        }
        return tmp;
    }

    public Student getStudentWithMaxAverageGrade()
    {
        //TODO:
        Student tmp = null;
        for(Student student : students)
        {
            if(tmp != null)
            {
                if (student.getAverageGrade() > tmp.getAverageGrade()) {
                    tmp = student;
                }
            }
            else
                tmp = student;
        }
        return tmp;
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }

    public Student getStudentWithMinAverageGrade()
    {
        Student tmp = null;
        for(Student student : students)
        {
            if(tmp != null)
            {
                if (student.getAverageGrade() < tmp.getAverageGrade()) {
                    tmp = student;
                }
            }
            else
                tmp = student;
        }
        return tmp;
    }

    public void expel(Student student)
    {
        students.remove(student);
    }
}