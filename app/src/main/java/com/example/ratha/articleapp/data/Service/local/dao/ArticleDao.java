package com.example.ratha.articleapp.data.Service.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ratha.articleapp.entity.Article;
import com.example.ratha.articleapp.entity.CategoryArticle;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

@Dao
public interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Article ... articles);
    @Update
    void edit(Article ... articles);
    @Delete
    void remove(Article ... articles);

    @Query("SELECT * FROM article WHERE id =:id")
    Article getOne(int id);

    @Query("SELECT * FROM article ORDER BY id DESC LIMIT :limit OFFSET :offset")
    List<Article> getArticles(int limit,int offset);

    @Query("SELECT art.*, cat.id as cat_id,cat.name as cat_name,cat.description as cat_desc,u.* FROM article art INNER JOIN " +
            "category cat on cat.id=art.category_id " +
            "INNER JOIN users u ON u.id=art.author_id "+
            " ORDER BY id DESC LIMIT :limit OFFSET :offset ")
    List<CategoryArticle> getCategoryWithArticles(int limit, int offset);

}
