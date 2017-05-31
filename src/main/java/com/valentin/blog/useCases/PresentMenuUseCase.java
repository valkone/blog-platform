package com.valentin.blog.useCases;

import com.valentin.blog.entities.Menu;
import com.valentin.blog.repositories.interfaces.MenuRepository;

import java.util.List;

public class PresentMenuUseCase {

    private MenuRepository<Menu> repository;

    public PresentMenuUseCase(MenuRepository<Menu> repository) {
        this.repository = repository;
    }

    public List<Menu> getAll() {
        return repository.getAll();
    }
}
