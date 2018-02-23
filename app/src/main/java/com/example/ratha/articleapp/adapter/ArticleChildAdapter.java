package com.example.ratha.articleapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.articleapp.R;
import com.example.ratha.articleapp.entity.Article;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

public class ArticleChildAdapter extends RecyclerView.Adapter<ArticleChildAdapter.ViewHolder> {

    private List<Article>  articles;
    private Context context;
    private ArticleChildCallBack callBack;
    public ArticleChildAdapter(Context context,List<Article> articles){
        this.articles=articles;this.context=context;
        this.callBack= (ArticleChildCallBack) context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.article_item_child_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article=articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        if(article.getThumb()==0)
            holder.ivThumb.setImageResource(R.drawable.ic_pictures_512dp);
        else
            holder.ivThumb.setImageResource(article.getThumb());

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private ImageView ivThumb;
        public ViewHolder(View itemView){
            super(itemView);
            this.tvTitle=itemView.findViewById(R.id.tvArticleTitle);
            this.ivThumb=itemView.findViewById(R.id.ivArticleThumb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.itemClicked(articles.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface ArticleChildCallBack{
        void itemClicked(Article article);
    }

}
