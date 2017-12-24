package com.example.peter.prac;

/**
 * Created by Peter on 12/24/2017.
 */

public class Person {
    public int uniqueId = 0;
    public String role = "";
    public String name = "";
    public String school = "";
    public int age = 0;
    public int imageId = 0;

    public Person(int uniqueId, String role, String name, String school, int age, int imageId) {
        this.uniqueId = uniqueId;
        this.role = role;
        this.name = name;
        this.school = school;
        this.age = age;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public int getImageId() {
        return this.imageId;
    }
}
