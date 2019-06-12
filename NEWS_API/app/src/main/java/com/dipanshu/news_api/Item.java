package com.dipanshu.news_api;

import android.os.Parcel;
import android.os.Parcelable;

import javax.xml.transform.Source;

public class Item {

    private String author, title, description, url, urltoImage, publishedAt,content;
    private Source object;

    Item(String author, String title, String description, String url, String urltoImage, String publishedAt, Source object, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.content=content;
        this.urltoImage = urltoImage;
        this.publishedAt= publishedAt;
        this.object=object;
        
    }



    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrltoImage() {
        return urltoImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public Source getObject() {
        return object;
    }

    public String getContent() {
        return content;
    }
}
