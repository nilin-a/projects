package com.example.sb_practice.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
    private long id;
    private String name;
    private String author;

    public Course(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course: id = " + id + ", name = " + name + ", author = " + author;
    }

}
