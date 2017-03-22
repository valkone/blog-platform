package com.valentin.blog.repositories.interfaces;

import com.valentin.blog.models.Entity;
import java.util.List;

public interface EntityRepository {
    void save(Entity entity);
    Entity findById(long id);
    List<Entity> getAll();
}