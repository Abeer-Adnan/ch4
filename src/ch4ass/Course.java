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
public class Course {
    private Integer id;
    private String name;
    private String room;
   
    public Course() {
    }

    public Course(Integer id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s ", id, name, room);
    }
     
}
