package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.Categories;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoriesService {
    public List<Categories> getAll();
    public Categories addUser(Categories categories);

    public Categories updateUser(Categories categories);

    public Categories findById(Long theId);

    public Categories getById2(Long id);

    public Categories deleteUser(Long id);

    public Page<Categories> getCategoriesPagination(Integer pageNumber, Integer pageSize);
}
