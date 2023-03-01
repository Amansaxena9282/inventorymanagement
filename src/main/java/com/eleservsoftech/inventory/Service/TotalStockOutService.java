package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.TotalStockOut;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TotalStockOutService {

    public List<TotalStockOut> getAll();

    public TotalStockOut findById(Long Id);

    public Page<TotalStockOut> getTotal_stock_outPagination(Integer pageNumber, Integer pageSize);
}
