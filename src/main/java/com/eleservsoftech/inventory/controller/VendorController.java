package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.CategoriesService;
import com.eleservsoftech.inventory.Service.VendorService;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Material;
import com.eleservsoftech.inventory.entity.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/getAll")
    public List<Vendor> allUsers() {
        return vendorService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public Vendor getById(@PathVariable Long Id) {
        Vendor vendor = vendorService.findById(Id);

        if(vendor == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return vendor;
    }
    @PostMapping("/add")
    public Vendor addEmployee(@RequestBody Vendor theVendor){

        return vendorService.addUser(theVendor);

    }
    @PutMapping("/update")
    public Vendor updateEmployee(@RequestBody Vendor theVendor) {

        return vendorService.updateUser(theVendor);
    }


    @DeleteMapping("/delete/{id}")
    public Vendor deleteUser(@PathVariable Long id){
        return vendorService.deleteUser(id);
    }


    @RequestMapping(value = "/pagination",method = RequestMethod.GET)
    public Page<Vendor> pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return vendorService.getVendorPagination(pageNumber,pageSize);
    }

}
