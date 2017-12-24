package com.example.peter.prac;

/**
 * Created by Peter on 12/24/2017.
 */

public class Person {
    public int uniqueId = 0;
    public String firstName = "";
    public String lastName = "";
    public String role = "";
    public String school = "";
    public int age = 0;
    public String intro = "";
    public int imageId = 0;

    public Person(int uniqueId, String firstName, String lastName, String role, String school,
                  int age, String intro, int imageId) {
        this.uniqueId = uniqueId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.school = school;
        this.age = age;
        this.intro = intro;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
    public int getImageId() {
        return this.imageId;
    }
}
