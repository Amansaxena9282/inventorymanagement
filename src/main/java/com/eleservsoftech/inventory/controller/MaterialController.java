package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Repository.MaterialRepository;
import com.eleservsoftech.inventory.Service.MaterialService;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Description;
import com.eleservsoftech.inventory.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @Autowired
    private MaterialRepository materialRepository;


    @GetMapping("/getAll")
    public List<Material> allUsers() {
        return materialService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public Material getById(@PathVariable Long Id) {
        Material material = materialService.findById(Id);

        if(material == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return material;
    }
    @PostMapping("/add")
    public Material addEmployee(@RequestBody Material theMaterial){

        return materialService.addUser(theMaterial);

    }
    @PutMapping("/update")
    public Material updateEmployee(@RequestBody Material theMaterial) {

        return materialService.updateUser(theMaterial);
    }

    @DeleteMapping("/delete/{id}")
    public Material deleteUser(@PathVariable Long id){
        return materialService.deleteUser(id);
    }



//
//    @RequestMapping(value="/pagination/{pageNumber}/{pageSize}",method = RequestMethod.GET)
//    public Page<Material> Pagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
//        return materialService.getMaterialPagination(pageNumber,pageSize);
//    }

    @RequestMapping(value="/pagination",method = RequestMethod.GET)
    public Page<Material> Pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return materialService.getMaterialPagination(pageNumber,pageSize);
    }

}
