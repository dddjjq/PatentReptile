package com.fanfan.patentreptile.entity;

import java.io.Serializable;

public class SoopatEntity implements Serializable {

    private String type;
    private String author;
    private String content;
    private String url;

    public SoopatEntity() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
