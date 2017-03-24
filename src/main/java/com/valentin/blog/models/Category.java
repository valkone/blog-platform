package com.valentin.blog.models;

public class Category extends Entity {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
