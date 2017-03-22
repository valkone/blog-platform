package com.valentin.blog.repositories.mocks;

import com.valentin.blog.exceptions.CannotSaveEntityException;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MockEntityRepository implements EntityRepository {

    private List<Entity> entities = new ArrayList<>();

    @Override
    public void save(Entity entity) {
        if(entity == null)
            throw new CannotSaveEntityException();
        entities.add(entity);
    }

    @Override
    public Entity findById(long id) {
        List<Entity> foundEntities = entities.stream().filter(a -> a.getId() == id).collect(Collectors.toList());
        return foundEntities.size() > 0 ? foundEntities.get(0) : null;
    }

    @Override
    public List<Entity> getAll() {
        return entities;
    }
}
