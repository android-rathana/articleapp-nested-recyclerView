package com.example.ratha.articleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ratha.articleapp.adapter.ArticleChildAdapter;
import com.example.ratha.articleapp.adapter.ParentAdapter;
import com.example.ratha.articleapp.data.Service.local.database.AppDatabase;
import com.example.ratha.articleapp.entity.Article;
import com.example.ratha.articleapp.entity.Category;
import com.example.ratha.articleapp.entity.CategoryArticle;
import com.example.ratha.articleapp.entity.ParentArticle;
import com.example.ratha.articleapp.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ParentAdapter.ParentAdapterCallBack, ArticleChildAdapter.ArticleChildCallBack{

    private RecyclerView rvParent;
    private List<ParentArticle> parentArticles =new ArrayList<>();
    private List<Article> articles=new ArrayList<>();
    private ParentAdapter parentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupParentArticleRecyclerView();
        setArticles();
        
        //insertUser();
        getaUser();
        //insertCatgory();
        getCategory();
        //addArticle();
        getArticle();
    }

    private void getArticle() {
        List<CategoryArticle> catArticle=AppDatabase.getDbInstance(this).articleDao().getCategoryWithArticles(15,0);
        for(CategoryArticle article: catArticle){
            Log.e(TAG, "getArticle: " +article.articles.get(0).getTitle() +
                    article.CategoryName+article.user.fullName );
        }
    }

    private void addArticle() {
        String contentText=getResources().getString(R.string.content_text);
       Article article= new Article("Arsenal ចាញ់ \u200Bតែ\u200Bឡើង\u200B\u200Bវគ្គ\u200B១៦\u200Bក្រុម\u200B Europa League",
                contentText+contentText,0);
       article.AuthorId=1;
       article.categoryId=1;
       AppDatabase.getDbInstance(this).articleDao().add(article);
    }

    private void getCategory() {
        List<Category> categories=AppDatabase.getDbInstance(this).categoryDao().getAll();
        for( Category cat: categories){
            Log.e(TAG, "getCategory: "+cat.toString() );
        }
    }

    private void insertCatgory() {
        Category cat=new Category();
        cat.name="Hot News";
        cat.desc="this category for hot news";

        Category cat2=new Category();
        cat2.name="Social News";
        cat2.desc="this category for Social News";
        AppDatabase.getDbInstance(this).categoryDao().add(cat,cat2);
    }

    private void getaUser() {
       User user= AppDatabase.getDbInstance(this).userDao().getOne(1);
        Log.e(TAG, "getaUser: "+user.toString() );
    }

    private void insertUser() {

        AppDatabase db= AppDatabase.getDbInstance(this);

        db.userDao().add(new User("rathana voy","rathanavoy@mgail.com",
                "male","099427776"));
    }

    private void setupParentArticleRecyclerView() {
        rvParent=findViewById(R.id.rvParent);
        parentAdapter=new ParentAdapter(this,parentArticles);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvParent.setLayoutManager(manager);
        rvParent.setAdapter(parentAdapter);
    }

    public void setArticles(){
        ParentArticle parentArticle1= new ParentArticle();
        ParentArticle parentArticle2= new ParentArticle();
        ParentArticle parentArticle3= new ParentArticle();
        ParentArticle parentArticle4= new ParentArticle();

        List<Article> articles2=new ArrayList<>();
        List<Article> articles4=new ArrayList<>();
        List<Article> articles5=new ArrayList<>();
        String contentText=getResources().getString(R.string.content_text);
        for(int i=0;i<7;i++){
            if(i==2 ||1==6){
                articles.add(new Article("Arsenal ចាញ់ \u200Bតែ\u200Bឡើង\u200B\u200Bវគ្គ\u200B១៦\u200Bក្រុម\u200B Europa League",
                        contentText+contentText));
            }
            else
                articles.add(new Article("Arsenal ចាញ់ \u200Bតែ\u200Bឡើង\u200B\u200Bវគ្គ\u200B១៦\u200Bក្រុម\u200B Europa League",
                        contentText+contentText,R.drawable.thumb));
        }

        for(int i=0;i<10;i++){
            if(i==2 ||1==6){
                articles2.add(new Article("ការពិត Couple Run ចូលដើមក្រុមហ៊ុនមិនស្ទើរ\u200B តែបើដឹងហេតុផលនេះ \u200Bរំភើបជំនួស",
                        contentText));
            }
            else
                articles2.add(new Article("មិនដែល\u200Bឮ\u200Bឈ្មោះ\u200Bសោះ ចេញ\u200Bប្រកាស\u200Bក្តែងៗ\u200Bស្មាតហ្វូន\u200Bខ្លួន\u200Bអាច\u200Bថត\u200Bរូប\u200Bនូវ\u200Bកម្រិត 80MP",
                        contentText,R.drawable.thumb));
        }

        for(int i=0;i<10;i++){
            if(i==2 ||1==6){
                articles4.add(new Article("ការពិត Couple Run ចូលដើមក្រុមហ៊ុនមិនស្ទើរ\u200B តែបើដឹងហេតុផលនេះ \u200Bរំភើបជំនួស",
                        contentText));
            }
            else
                articles4.add(new Article("មិនដែល\u200Bឮ\u200Bឈ្មោះ\u200Bសោះ ចេញ\u200Bប្រកាស\u200Bក្តែងៗ\u200Bស្មាតហ្វូន\u200Bខ្លួន\u200Bអាច\u200Bថត\u200Bរូប\u200Bនូវ\u200Bកម្រិត 80MP",
                        contentText,R.drawable.thumb));
        }
        for(int i=0;i<10;i++){
            if(i==2 ||1==6){
                articles5.add(new Article("ការពិត Couple Run ចូលដើមក្រុមហ៊ុនមិនស្ទើរ\u200B តែបើដឹងហេតុផលនេះ \u200Bរំភើបជំនួស",
                        contentText));
            }
            else
                articles5.add(new Article("មិនដែល\u200Bឮ\u200Bឈ្មោះ\u200Bសោះ ចេញ\u200Bប្រកាស\u200Bក្តែងៗ\u200Bស្មាតហ្វូន\u200Bខ្លួន\u200Bអាច\u200Bថត\u200Bរូប\u200Bនូវ\u200Bកម្រិត 80MP",
                        contentText,R.drawable.thumb));
        }

        parentArticle1.setArticles(articles);
        parentArticle2.setArticles(articles2);
        parentArticle3.setArticles(articles4);
        parentArticle4.setArticles(articles5);
        this.parentArticles.add(parentArticle1);
        this.parentArticles.add(parentArticle2);
        this.parentArticles.add(parentArticle3);
        this.parentArticles.add(parentArticle4);
        this.parentAdapter.notifyDataSetChanged();
    }

    @Override
    public void seeMoreClicked(int catId) {
        Intent intent=new Intent(this,CategoryActivity.class);
        intent.putExtra("catId",catId);
        startActivity(intent);
    }

    private static final String TAG = "MainActivity";

    @Override
    public void itemClicked(Article article) {
        Intent intent= new Intent(this,ArticleDetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putParcelable("article",article);
        intent.putExtras(bundle);
        startActivity(intent);
        Log.e(TAG, "itemClicked: "+ article.toString());
    }
}
