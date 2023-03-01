package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.entity.TotalScrapping;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TotalScrappingService {

    public List<TotalScrapping> getAll();

    public TotalScrapping findById(Long Id);

    public Page<TotalScrapping> getTotal_scrapping(Integer pageNumber, Integer pageSize);

}
