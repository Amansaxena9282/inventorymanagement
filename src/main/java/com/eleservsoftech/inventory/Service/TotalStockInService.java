package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.TotalStockIn;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TotalStockInService {

    public List<TotalStockIn> getAll();

    public TotalStockIn findById(Long Id);

    public Page<TotalStockIn> getTotal_stock_inPagination(Integer pageNumber, Integer pageSize);
}
