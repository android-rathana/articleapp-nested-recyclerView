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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private List<Article> articles;
    private Context context;
    private CategoryArticleCallBack callBack;
    public ArticleAdapter(Context context, List<Article> articles){
        this.context=context; this.articles=articles;
        this.callBack= (CategoryArticleCallBack) context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.article_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article=articles.get(position);
        if(article.getThumb()==0)
            holder.ivThumb.setImageResource(R.drawable.ic_pictures_512dp);
        else
            holder.ivThumb.setImageResource(article.getThumb());

        holder.tvTitle.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivThumb;
        private ImageView btnLike;
        private ImageView btnComment;
        private ImageView btnShare;
        private ImageView btnBookmark;
        private TextView tvTitle;

        public  ViewHolder(View itemView){
            super(itemView);
            ivThumb=itemView.findViewById(R.id.ivArticleThumb);
            btnBookmark=itemView.findViewById(R.id.btnBookmark);
            btnComment=itemView.findViewById(R.id.btnComment);
            btnLike=itemView.findViewById(R.id.btnLike);
            btnShare=itemView.findViewById(R.id.btnShared);
            tvTitle=itemView.findViewById(R.id.tvArticleTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBack.itemLicked(articles.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface CategoryArticleCallBack{
        void itemLicked(Article article);
    }

}
