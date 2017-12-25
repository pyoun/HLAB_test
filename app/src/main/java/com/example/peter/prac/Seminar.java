package com.example.peter.prac;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 12/24/2017.
 */

public class Seminar {
    public int seminarId = 0;
    public String seminarName = "";
    public String cmName = "";
    public String ecName = "";
    public String seminarStudents = "";
    //public List<Seminar> seminarStudents = new ArrayList<Seminar>();
    public String seminarIntro = "";
    public int seminarPic = 0;

    public Seminar(int seminarId, String seminarName, String cmName, String ecName,
                   String seminarStudents, String seminarIntro, int seminarPic) {
        this.seminarId = seminarId;
        this.seminarName = seminarName;
        this.cmName = cmName;
        this.ecName = ecName;
        this.seminarStudents = seminarStudents;
        this.seminarIntro = seminarIntro;
        this.seminarPic = seminarPic;
    }

    @Override
    public String toString() {
        return this.seminarName;
    }
    public String getIntro() { return this.seminarIntro; }
    public String getStudents() { return this.seminarStudents; }
    //public List<Seminar> getStudents() { return this.seminarStudents; }
    public int getImageId() {
        return this.seminarPic;
    }
}
