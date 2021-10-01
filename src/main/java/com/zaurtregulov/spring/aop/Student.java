package com.zaurtregulov.spring.aop;

public class Student {
    private String nameStudent;
    private int course;
    private double avgGrade;

    public Student(String nameStudent, int course, double avgGrade) {
        this.nameStudent = nameStudent;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameStudent='" + nameStudent + '\'' +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
