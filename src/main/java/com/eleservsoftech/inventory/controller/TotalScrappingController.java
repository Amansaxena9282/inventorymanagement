package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.TotalScrappingService;
import com.eleservsoftech.inventory.entity.TotalScrapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/total_scrapping")
public class TotalScrappingController {
    @Autowired
    private TotalScrappingService total_scrappingService;

    @GetMapping("/getAll")
    private List<TotalScrapping> getAll(){
        return total_scrappingService.getAll();
    }


    @GetMapping("/findById/{Id}")
    public TotalScrapping getById(@PathVariable Long Id) {
        TotalScrapping total_scrapping = total_scrappingService.findById(Id);

        if(total_scrapping == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return total_scrapping;
    }
    @RequestMapping(value ="/pagination",method = RequestMethod.GET)
    public Page<TotalScrapping> pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return total_scrappingService.getTotal_scrapping(pageNumber,pageSize);
    }
}
