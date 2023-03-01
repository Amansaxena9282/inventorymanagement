package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.StockIn;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StockInService {

    public List<StockIn> getAll();
    public StockIn addUser(StockIn stock_in);

    public StockIn updateUser(StockIn stock_in);

    public StockIn findById(Long theId);

    public StockIn deleteUser(Long id);

    public Page<StockIn> getStock_inPagination(Integer pageNumber, Integer pageSize);
}
