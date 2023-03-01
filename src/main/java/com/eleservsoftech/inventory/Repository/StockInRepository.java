package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.entity.StockIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInRepository extends JpaRepository<StockIn,Long> {
}
