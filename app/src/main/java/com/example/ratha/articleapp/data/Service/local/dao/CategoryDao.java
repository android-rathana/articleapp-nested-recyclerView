package com.example.ratha.articleapp.data.Service.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ratha.articleapp.entity.Category;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category ORDER BY id DESC")
    List<Category> getAll();
    @Query("SELECT * FROM category WHERE id = :id")
    List<Category> getOne(int id);
    @Query("SELECT * FROM category WHERE name LIKE :name")
    List<Category> getByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Category ... categories);
    @Update
    void edit(Category ... categories);
    @Delete
    void remove(Category ... categories);
}
