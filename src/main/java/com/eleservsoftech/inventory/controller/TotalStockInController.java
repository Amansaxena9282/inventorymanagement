package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.TotalStockInService;
import com.eleservsoftech.inventory.entity.TotalStockIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/total_stock_in")
public class TotalStockInController {
    @Autowired
    private TotalStockInService total_stock_inService;

    @GetMapping("/getAll")
    private List<TotalStockIn> getAll(){
        return total_stock_inService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public TotalStockIn getById(@PathVariable Long Id) {
        TotalStockIn total_stock_in = total_stock_inService.findById(Id);

        if(total_stock_in == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return total_stock_in;
    }
    @RequestMapping(value = "/pagination",method =RequestMethod.GET)
    public Page<TotalStockIn> pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return total_stock_inService.getTotal_stock_inPagination(pageNumber,pageSize);
    }
}
