package com.example.ratha.articleapp.entity;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

public class ParentArticle {

    private List<Article> articles;
    private int categoryId;
    private String CategoryName;

    public ParentArticle() {
    }

    public ParentArticle(String categoryName) {
        CategoryName = categoryName;
    }

    public ParentArticle(List<Article> articles, String categoryName) {
        this.articles = articles;
        CategoryName = categoryName;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
