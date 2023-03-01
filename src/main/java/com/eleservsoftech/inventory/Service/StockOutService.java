package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.StockOut;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StockOutService {

    public List<StockOut> getAll();
    public StockOut addUser(StockOut stock_out);

    public StockOut updateUser(StockOut stock_out);

    public StockOut findById(Long theId);

    public StockOut deleteUser(Long id);

   public Page<StockOut> getCategoriesPagination(Integer pageNumber, Integer pageSize);
}
