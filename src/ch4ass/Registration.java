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
public class Registration {
    private Integer studentid;
    private Integer courseid;
    private String semeste;
    

    public Registration() {
    }

    public Registration(Integer studentid, Integer courseid, String semeste) {
        this.studentid = studentid;
        this.courseid = courseid;
        this.semeste = semeste;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSemeste() {
        return semeste;
    }

    public void setSemeste(String semeste) {
        this.semeste = semeste;
    }

    @Override
    public String toString() {
            return String.format("%-5s %-5s %-10s ", studentid, courseid,semeste);
}    }
    
