package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material,Long> {
}
