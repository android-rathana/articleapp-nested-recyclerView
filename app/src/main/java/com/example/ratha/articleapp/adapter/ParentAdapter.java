package com.example.ratha.articleapp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ratha.articleapp.R;
import com.example.ratha.articleapp.entity.Article;
import com.example.ratha.articleapp.entity.Category;
import com.example.ratha.articleapp.entity.ParentArticle;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

public class ParentAdapter  extends RecyclerView.Adapter<ParentAdapter.ViewHolder>{

    private List<ParentArticle> parentArticles;
    private Context  context;
    private ParentAdapterCallBack callBack;
    public ParentAdapter(Context context, List<ParentArticle> parentArticles){
        this.context=context; this.parentArticles=parentArticles;
        this.callBack= (ParentAdapterCallBack) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.parent_article_adapter_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ParentArticle parentArticle=parentArticles.get(position);
        setupChildRecyclerView(holder.rvChild,parentArticle.getArticles());

        //set update event
        holder.btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.seeMoreClicked(parentArticle.getCategoryId());
            }
        });
    }


    @Override
    public int getItemCount() {
        return parentArticles.size();
    }

    void setupChildRecyclerView(RecyclerView rvChild ,List<Article> articles){
        RecyclerView.LayoutManager manager=new LinearLayoutManager(context, LinearLayout.HORIZONTAL,false);
        rvChild.setLayoutManager(manager);
        rvChild.setHasFixedSize(true);
        //create child adapter object
        ArticleChildAdapter articleChildAdapt=new ArticleChildAdapter(context,articles);
        rvChild.setAdapter(articleChildAdapt);


    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvCategoryName;
        private RecyclerView rvChild;
        private TextView btnSeeMore;
        public ViewHolder(View itemView){
            super(itemView);
            this.tvCategoryName=itemView.findViewById(R.id.tvCategoryName);
            this.rvChild=itemView.findViewById(R.id.rvChild);
            this.btnSeeMore=itemView.findViewById(R.id.btnSeeMore);
        }
    }

    public interface ParentAdapterCallBack{
        void seeMoreClicked(int CatId);
    }


}
