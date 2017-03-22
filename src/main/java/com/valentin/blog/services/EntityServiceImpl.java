package com.valentin.blog.services;

import com.valentin.blog.dtos.EntityDTO;
import com.valentin.blog.models.Entity;
import com.valentin.blog.repositories.interfaces.EntityRepository;
import com.valentin.blog.services.interfaces.EntityService;
import com.valentin.blog.utils.Mapper;

import java.util.List;

public class EntityServiceImpl implements EntityService {

    private EntityRepository repository;

    public EntityServiceImpl(EntityRepository repository) {
        this.repository = repository;
    }

    public void save(Entity entity) {
        repository.save(entity);
    }

    @Override
    public void save(List<Entity> entities) {
        for(Entity entity: entities)
            save(entity);
    }

    public EntityDTO findById(long id) {
        Entity entity = repository.findById(id);
        return Mapper.entityToDto(entity);
    }

    @Override
    public List<EntityDTO> getAll() {
        return Mapper.entitiesToDto(repository.getAll());
    }
}
