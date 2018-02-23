package com.example.ratha.articleapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ratha on 2/23/2018.
 */

@Entity(tableName = "category")
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    @ColumnInfo(name = "description")
    public String desc;
    @Ignore
    public Category() {}
    @Ignore
    public Category(String name) {
        this.name = name;
    }
    @Ignore
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
