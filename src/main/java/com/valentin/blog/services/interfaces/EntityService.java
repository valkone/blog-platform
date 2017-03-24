package com.valentin.blog.services.interfaces;

import com.valentin.blog.models.Entity;

import java.util.List;

public interface EntityService {
    void save(Entity entity);
    void save(List<Entity> entities);
    Entity findById(long id);
    List<Entity> getAll();
}
