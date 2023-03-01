package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.TotalStockInRepository;
import com.eleservsoftech.inventory.entity.TotalStockIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class TotalStockInServiceImpl implements TotalStockInService {
    @Autowired
    private TotalStockInRepository total_stock_inRepository;
    @Override
    public List<TotalStockIn> getAll() {
        log.info("Total stock_in service implementation:getALl-->");
        List<TotalStockIn> result = null;
        try{
            result = total_stock_inRepository.findAll();
        }
        catch(Exception e){
            log.error("Total stock_in service Implementation :error"+e.getMessage());
        }
        return result;
    }

    @Override
    public TotalStockIn findById(Long Id) {
        log.info("Total stock_in service implementation:findById-->");
        Optional<TotalStockIn> result = total_stock_inRepository.findById(Id);
        TotalStockIn total_stock_in = null;
        try{
            if(result.isPresent()) {
                total_stock_in = result.get();
            }
            else {
                throw new RuntimeException("Did not find the id-"+Id);
            }
        }
        catch(Exception e){
            log.error("Total stock_in service Implementation :error"+e.getMessage());
        }

        return total_stock_in;
    }

    @Override
    public Page<TotalStockIn> getTotal_stock_inPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return total_stock_inRepository.findAll(pageable);
    }
}
