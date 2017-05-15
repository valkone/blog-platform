package com.valentin.blog.repositories.interfaces;

import com.valentin.blog.entities.Entity;
import java.util.List;

public interface EntityRepository<T extends Entity> {
    void save(T entity);
    T findById(long id);
    List<T> getAll();
}