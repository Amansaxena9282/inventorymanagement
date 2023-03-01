package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Service.CategoriesService;
import com.eleservsoftech.inventory.entity.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/getAll")
    public List<Categories> allUsers() {
        return categoriesService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public Categories getById(@PathVariable Long Id) {
        Categories categories = categoriesService.findById(Id);

        if(categories == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return categories;
    }
    @GetMapping("/getid/{Id}")
    public Categories getById2(@PathVariable Long Id){
        return categoriesService.getById2(Id);
    }
    @PostMapping("/add")
    public Categories addEmployee(@RequestBody Categories theCategories){

        return categoriesService.addUser(theCategories);

    }
    @PutMapping("/update")
    public Categories updateEmployee(@RequestBody Categories theCategories) {

        return categoriesService.updateUser(theCategories);
    }

    @DeleteMapping("/delete/{id}")
    public Categories deleteUser(@PathVariable Long id){
        return categoriesService.deleteUser(id);
    }

    @RequestMapping(value="/pagination",method = RequestMethod.GET)
    public Page<Categories> Pagination(@RequestParam("pageNumber") Integer pageNumber,@RequestParam("pageSize") Integer pageSize){
        return categoriesService.getCategoriesPagination(pageNumber,pageSize);
    }




}
