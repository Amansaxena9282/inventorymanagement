package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
}
