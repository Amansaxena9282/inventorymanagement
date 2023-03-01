package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.StockInService;
import com.eleservsoftech.inventory.entity.StockIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/stock_in")
public class StockInController {
    @Autowired
    private StockInService stock_inService;

    @GetMapping("/getAll")
    public List<StockIn> allUsers() {
        return stock_inService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public StockIn getById(@PathVariable Long Id) {
        StockIn stock_in = stock_inService.findById(Id);

        if(stock_in == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return stock_in;
    }
    @PostMapping("/add")
    public StockIn addEmployee(@RequestBody StockIn theStock_in){

        return stock_inService.addUser(theStock_in);

    }
    @PutMapping("/update")
    public StockIn updateEmployee(@RequestBody StockIn theStock_in) {

        return stock_inService.updateUser(theStock_in);
    }

    @DeleteMapping("/delete/{id}")
    public StockIn deleteUser(@PathVariable Long id){
        return stock_inService.deleteUser(id);
    }

    @RequestMapping(value = "/pagination",method = RequestMethod.GET)
    public Page<StockIn> Pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return stock_inService.getStock_inPagination(pageNumber,pageSize);
    }


}
