package com.example.ratha.articleapp.entity;

/**
 * Created by ratha on 2/23/2018.
 */

public class Category {
    private int id;
    private String name;
    private String desc;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String desc) {
        this(name);
        this.desc = desc;
    }

    public Category(int id, String name, String desc) {
        this(name,desc);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
