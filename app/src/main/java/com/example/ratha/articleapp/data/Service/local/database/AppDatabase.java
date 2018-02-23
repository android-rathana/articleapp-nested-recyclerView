package com.example.ratha.articleapp.data.Service.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ratha.articleapp.data.Service.local.dao.ArticleDao;
import com.example.ratha.articleapp.data.Service.local.dao.CategoryDao;
import com.example.ratha.articleapp.data.Service.local.dao.UserDao;
import com.example.ratha.articleapp.entity.Article;
import com.example.ratha.articleapp.entity.Category;
import com.example.ratha.articleapp.entity.User;

/**
 * Created by ratha on 2/23/2018.
 */

@Database(version = 1,entities = {User.class, Category.class, Article.class})
public abstract class AppDatabase extends RoomDatabase {

    //create abstract method to get dao
    public abstract UserDao userDao();
    public abstract CategoryDao categoryDao();
    public abstract ArticleDao articleDao();

    public static AppDatabase getDbInstance(Context context){
        return Room.databaseBuilder(context,AppDatabase.class,"article_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

}
