package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.TotalStockOutRepository;
import com.eleservsoftech.inventory.entity.TotalStockOut;
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
public class TotalStockOutServiceImpl implements TotalStockOutService {
    @Autowired
    private TotalStockOutRepository total_stock_outRepository;

    @Override
    public List<TotalStockOut> getAll() {
        log.info("Total_stock_out service implementation:getAll-->");
        List<TotalStockOut> result = null;
        try{
            result = total_stock_outRepository.findAll();
        }
        catch(Exception e){
            log.error("Total stock_out service Implementation :error"+e.getMessage());
        }
        return result;
    }

    @Override
    public TotalStockOut findById(Long Id) {
        log.info("Total_stock_out service implementation:findById-->");
        Optional<TotalStockOut> result = total_stock_outRepository.findById(Id);
        TotalStockOut total_stock_out = null;
        try{
            if(result.isPresent()) {
                total_stock_out = result.get();
            }
            else {
                throw new RuntimeException("Did not find the id-"+Id);
            }
        }
        catch(Exception e){
            log.error("Total stock_out service Implementation :error"+e.getMessage());
        }

        return total_stock_out;
    }

    @Override
    public Page<TotalStockOut> getTotal_stock_outPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return total_stock_outRepository.findAll(pageable);
    }
}
