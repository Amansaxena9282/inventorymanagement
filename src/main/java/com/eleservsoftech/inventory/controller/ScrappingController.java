package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.ScrappingService;
import com.eleservsoftech.inventory.entity.Material;
import com.eleservsoftech.inventory.entity.Scrapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/scrapping")
public class ScrappingController {
    @Autowired
    private ScrappingService scrappingService;
    @GetMapping("/getAll")
    public List<Scrapping> allUsers() {
        return scrappingService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public Scrapping getById(@PathVariable Long Id) {
        Scrapping scrapping = scrappingService.findById(Id);

        if(scrapping == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return scrapping;
    }
    @PostMapping("/add")
    public Scrapping addEmployee(@RequestBody Scrapping theScrapping){

        return scrappingService.addUser(theScrapping);

    }
    @PutMapping("/update")
    public Scrapping updateEmployee(@RequestBody Scrapping theScrapping) {

        return scrappingService.updateUser(theScrapping);
    }
    @DeleteMapping("/delete/{id}")
    public Scrapping deleteUser(@PathVariable Long id){
        return scrappingService.deleteUser(id);
    }

    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    public Page<Scrapping> Pagination(@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize){
        return scrappingService.getScrappingPagination(pageNumber,pageSize);
    }
}
