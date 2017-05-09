package com.valentin.blog.models;

public class Category extends Entity {
    private String text;

    public Category setText(String text) {
        this.text = text;
        return this;
    }

    public String getText() {
        return text;
    }

    @Override
    public Category setId(long id) {
        super.setId(id);
        return this;
    }
}
