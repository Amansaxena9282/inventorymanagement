package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.TotalStockOutService;
import com.eleservsoftech.inventory.entity.TotalStockOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/total_stock_out")
public class TotalStockOutController {
    @Autowired
    private TotalStockOutService total_stock_outService;

    @GetMapping("/getAll")
    private List<TotalStockOut> getAll(){
        return total_stock_outService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public TotalStockOut getById(@PathVariable Long Id) {
        TotalStockOut total_stock_out = total_stock_outService.findById(Id);

        if(total_stock_out == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return total_stock_out;
    }
    @RequestMapping(value = "/pagination",method = RequestMethod.GET)
    public Page<TotalStockOut> pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return total_stock_outService.getTotal_stock_outPagination(pageNumber,pageSize);
    }
}
