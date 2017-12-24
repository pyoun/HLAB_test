package com.example.peter.prac;

/**
 * Created by Peter on 12/24/2017.
 */

public class Seminar {
    public int seminarId = 0;
    public String seminarName = "";
    public String cmName = "";
    public String ecName = "";
    public String seminarIntro = "";
    public int seminarPic = 0;

    public Seminar(int seminarId, String seminarName, String cmName, String ecName,
                   String seminarIntro, int seminarPic) {
        this.seminarId = seminarId;
        this.seminarName = seminarName;
        this.cmName = cmName;
        this.ecName = ecName;
        this.seminarIntro = seminarIntro;
        this.seminarPic = seminarPic;
    }

    @Override
    public String toString() {
        return this.seminarName;
    }
    public String getIntro() { return this.seminarIntro; }
    public int getImageId() {
        return this.seminarPic;
    }
}
