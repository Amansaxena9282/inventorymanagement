package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Description;
import com.eleservsoftech.inventory.entity.Material;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MaterialService {

    public List<Material> getAll();
    public Material addUser(Material material);

    public Material updateUser(Material material);

    public Material findById(Long theId);


    public Material deleteUser(Long id);

    public Page<Material> getMaterialPagination(Integer pageNumber, Integer pageSize);
}
