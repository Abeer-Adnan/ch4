/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4ass;

/**
 *
 * @author rant
 */
public class Student {
    private Integer id;
    private String name;
    private String major;
    private Double grade;

    public Student() {
    }

    public Student(Integer id, String name, String Major, Double Grade) {
        this.id = id;
        this.name = name;
        this.major = Major;
        this.grade = Grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String Major) {
        this.major = Major;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double Grade) {
        this.grade = Grade;
    }

    @Override
    public String toString() {
       return String.format("%-5s %-10s %-10s %8.2f", id, name, major, grade);
    }
    
    
}
