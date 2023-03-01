package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Material;
import com.eleservsoftech.inventory.entity.Scrapping;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ScrappingService {

    public List<Scrapping> getAll();
    public Scrapping addUser(Scrapping scrapping);

    public Scrapping updateUser(Scrapping scrapping);

    public Scrapping findById(Long theId);
    public Scrapping deleteUser(Long id);

    public Page<Scrapping> getScrappingPagination(Integer pageNumber, Integer pageSize);
}
