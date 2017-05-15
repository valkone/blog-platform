package com.valentin.blog.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article extends Entity {

    private String text;
    private String title;
    private Date data;
    private List<Category> categories = new ArrayList<>();

    public Article(){
    }

    public Article(long id) {
        this.setId(id);
    }

    public String getText() {
        return text;
    }

    @Override
    public Article setId(long id) {
        super.setId(id);
        return this;
    }

    public Article setText(String text) {
        this.text = text;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Article setData(Date data) {
        this.data = data;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Article setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public Article setCategory(Category category) {
        this.categories.add(category);
        return this;
    }
}
