package com.example.ratha.articleapp.data.Service.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ratha.articleapp.entity.User;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User ... users);

    @Query("SELECT * FROM users ORDER BY id DESC")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id = :id")
    User getOne(int id);

    @Query("SELECT * FROM users WHERE email LIKE :email")
    User getByEmail(String email);

    @Update
    void edit(User ... users);

    @Delete
    void remove(User ...  users);

}
