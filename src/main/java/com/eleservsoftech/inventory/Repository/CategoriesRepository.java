package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
