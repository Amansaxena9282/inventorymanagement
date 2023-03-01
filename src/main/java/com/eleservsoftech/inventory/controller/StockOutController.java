package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.StockOutService;
import com.eleservsoftech.inventory.entity.StockOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/stock_out")
public class StockOutController {


    @Autowired
    private StockOutService stock_outService;

    @GetMapping("/getAll")
    public List<StockOut> allUsers() {
        return stock_outService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public StockOut getById(@PathVariable Long Id) {
        StockOut stock_out = stock_outService.findById(Id);

        if(stock_out == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return stock_out;
    }
    @PostMapping("/add")
    public StockOut addEmployee(@RequestBody StockOut theStock_out){

        return stock_outService.addUser(theStock_out);

    }
    @PutMapping("/update")
    public StockOut updateEmployee(@RequestBody StockOut theStock_out) {

        return stock_outService.updateUser(theStock_out);
    }
    @DeleteMapping("/delete/{id}")
    public StockOut deleteUser(@PathVariable Long id){
        return stock_outService.deleteUser(id);
    }

    @RequestMapping(value="/pagination",method = RequestMethod.GET)
    public Page<StockOut> employeePagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return stock_outService.getCategoriesPagination(pageNumber,pageSize);
    }


}
