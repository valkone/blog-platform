package com.valentin.blog.services;

import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;

import java.util.List;

public class EntityService {

    private EntityRepository repository;

    public EntityService(EntityRepository repository) {
        this.repository = repository;
    }

    public void save(Entity entity) {
        repository.save(entity);
    }

    public void save(List<Entity> entities) {
        for(Entity entity: entities)
            save(entity);
    }

    public Entity findById(long id) {
        return repository.findById(id);
    }

    public List<Entity> getAll() {
        return repository.getAll();
    }
}
