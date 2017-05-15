package com.valentin.blog.repositories.mocks;

import com.valentin.blog.entities.Menu;
import com.valentin.blog.repositories.interfaces.MenuRepository;

public class MemoryMenuRepository extends MemoryEntityRepository<Menu> implements MenuRepository<Menu> {
}
