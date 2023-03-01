package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.Vendor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VendorService{


    public List<Vendor> getAll();
    public Vendor addUser(Vendor vendor);

    public Vendor updateUser(Vendor vendor);

    public Vendor findById(Long theId);

    public Vendor deleteUser(Long id);

    public Page<Vendor> getVendorPagination(Integer pageNumber,Integer pageSize);
}
