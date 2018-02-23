package com.example.ratha.articleapp.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by ratha on 2/23/2018.
 */

@Entity(tableName = "article")
public class Article implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    @ColumnInfo(name = "content_text")
    public String contentText;
    @ColumnInfo(name = "thumbnail")
    public int thumb;
    @ColumnInfo(name = "category_id")
    public int categoryId;
    @ColumnInfo(name = "author_id")
    public int AuthorId;

    public Article(){}
    @Ignore
    public Article(String title, String contentText, int thumb) {
        this.title = title;
        this.contentText = contentText;
        this.thumb = thumb;
    }
    @Ignore
    public Article(String title) {
        this.title = title;
    }
    @Ignore
    public Article(String title, String contentText) {
        this.title = title;
        this.contentText = contentText;
    }
    @Ignore
    public Article(String title, int thumb) {
        this.title = title;
        this.thumb=thumb;
    }
    public Article(int id,String title, String contentText, int thumb, int categoryId, int authorId) {
        this.id=id;
        this.title = title;
        this.contentText = contentText;
        this.thumb = thumb;
        this.categoryId = categoryId;
        AuthorId = authorId;
    }
    public Article(String title, String contentText, int thumb, int categoryId, int authorId) {
        this.title = title;
        this.contentText = contentText;
        this.thumb = thumb;
        this.categoryId = categoryId;
        AuthorId = authorId;
    }

    @Ignore
    protected Article(Parcel in) {
        id = in.readInt();
        title = in.readString();
        contentText = in.readString();
        thumb = in.readInt();
        categoryId = in.readInt();
        AuthorId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(contentText);
        dest.writeInt(thumb);
        dest.writeInt(categoryId);
        dest.writeInt(AuthorId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(int authorId) {
        AuthorId = authorId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contentText='" + contentText + '\'' +
                ", thumb=" + thumb +
                ", categoryId=" + categoryId +
                ", AuthorId=" + AuthorId +
                '}';
    }
}
