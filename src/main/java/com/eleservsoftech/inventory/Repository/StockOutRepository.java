package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.entity.StockOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockOutRepository extends JpaRepository<StockOut,Long> {
}
