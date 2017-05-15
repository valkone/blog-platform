package com.valentin.blog.entities;

public class Entity {
    private long id;

    public Entity() {
    }

    public Entity(long id) {
        this.setId(id);
    }

    public long getId() {
        return id;
    }

    public Object setId(long id) {
        this.id = id;
        return this;
    }
}
