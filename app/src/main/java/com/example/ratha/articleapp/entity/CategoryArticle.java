package com.example.ratha.articleapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.lang.annotation.Retention;
import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

public class CategoryArticle {
    @ColumnInfo(name = "cat_id")
    public int catId;
    @ColumnInfo(name = "cat_name")
    public String CategoryName;
    @ColumnInfo(name = "cat_desc")
    public String CategoryDesc;
    @Relation(parentColumn = "id", entityColumn = "category_id")
    public List<Article> articles;
    @Embedded
    public User user;

}
