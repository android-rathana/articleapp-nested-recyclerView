package com.example.ratha.articleapp.fragment;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ratha.articleapp.R;
import com.example.ratha.articleapp.entity.Article;

/**
 * Created by ratha on 2/23/2018.
 */

public class ArticleDetailFragment extends Fragment {

    private Article article;
    private ImageView ivPhoto;
    private TextView tvTitle;
    private TextView tvContentText;
    public void setArticle(Article article) {
        this.article = article;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.article_detail_fragment_layout,container,false);

        ivPhoto=view.findViewById(R.id.ivArticlePhoto);
        tvTitle=view.findViewById(R.id.tvArticleTitle);
        tvContentText=view.findViewById(R.id.tvContentText);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(article!=null){
            tvTitle.setText(article.getTitle());
            tvContentText.setText(article.getContentText());
            if(article.getThumb()==0)
                ivPhoto.setImageResource(R.drawable.ic_pictures_512dp);
            else
                ivPhoto.setImageResource(article.getThumb());
        }
    }
}
