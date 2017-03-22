package com.valentin.blog.models;

import java.util.Date;

public class Article extends Entity {

    private String text;
    private String title;
    private Date data;

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
