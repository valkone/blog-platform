package com.valentin.blog.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article extends Entity {

    private String text;
    private String title;
    private Date data;
    private List<Category> categories = new ArrayList<>();

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCategory(Category category) {
        this.categories.add(category);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
