package com.valentin.blog.entities;

public class Menu extends Entity {

    private String name;
    private String link;

    public Menu() {
    }

    public Menu(long id) {
        this.setId(id);
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Menu setLink(String link) {
        this.link = link;
        return this;
    }
}
