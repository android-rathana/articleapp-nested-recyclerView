package com.example.ratha.articleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ratha.articleapp.adapter.ArticleAdapter;
import com.example.ratha.articleapp.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements ArticleAdapter.CategoryArticleCallBack{

    private RecyclerView rvCategory;
    private List<Article> articles =new ArrayList<>();
    private ArticleAdapter articleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setupCategoryRecyclerView();

        //get data from intent
        Intent intent=getIntent();
        int catId=0;
        if(intent!=null){
            catId=intent.getIntExtra("catId",0);
        }
        setupArticles(catId);
    }

    private void setupCategoryRecyclerView() {
        rvCategory=findViewById(R.id.rvCategory);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter=new ArticleAdapter(this,articles);
        rvCategory.setAdapter(articleAdapter);
    }

    public void setupArticles(int catId){
        String contentText=getResources().getString(R.string.content_text);
        for(int i=0;i<10;i++){
            if(i==2 ||1==6)
                articles.add(new Article("ការពិត Couple Run ចូលដើមក្រុមហ៊ុនមិនស្ទើរ\u200B តែបើដឹងហេតុផលនេះ \u200Bរំភើបជំនួស",
                        contentText));
            else
                articles.add(new Article("មិនដែល\u200Bឮ\u200Bឈ្មោះ\u200Bសោះ ចេញ\u200Bប្រកាស\u200Bក្តែងៗ\u200Bស្មាតហ្វូន\u200Bខ្លួន\u200Bអាច\u200Bថត\u200Bរូប\u200Bនូវ\u200Bកម្រិត 80MP",
                        contentText, R.drawable.thumb));
        }
        this.articleAdapter.notifyDataSetChanged();
    }


    private static final String TAG = "CategoryActivity";
    @Override
    public void itemLicked(Article article) {
        Intent intent= new Intent(this,ArticleDetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("article",article);
        intent.putExtras(bundle);
        startActivity(intent);
        Log.e(TAG, "itemClicked: "+ article.toString());
    }
}
