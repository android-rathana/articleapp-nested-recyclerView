package com.example.ratha.articleapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ratha.articleapp.entity.Article;
import com.example.ratha.articleapp.fragment.ArticleDetailFragment;

public class ArticleDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        //get data
        Article article=null;
        Intent intent=getIntent();
        if(intent!=null){
            article=intent.getParcelableExtra("article");
        }


        FragmentTransaction t=getFragmentManager().beginTransaction();
        ArticleDetailFragment fragment=new ArticleDetailFragment();
        fragment.setArticle(article);
        t.add(R.id.articleDetailContainer,fragment);
        t.commit();
    }
}
