package com.eleservsoftech.inventory.controller;

import com.eleservsoftech.inventory.Model.Stagging;
import com.eleservsoftech.inventory.Service.DescriptionService;
import com.eleservsoftech.inventory.Service.DescriptionServiceImpl;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Description;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eleserv/description")
public class DescriptionController {
    @Autowired
    private DescriptionService descriptionService;

    @GetMapping("/getAll")
    public List<Description> allUsers() {
        return descriptionService.getAll();
    }

    @GetMapping("/findById/{Id}")
    public Description getById(@PathVariable Long Id) {
        Description description = descriptionService.findById(Id);

        if(description == null)
        {
            throw new RuntimeException("employee id not found "+Id);
        }

        return description;
    }
    @PostMapping("/add")
    public Description addEmployee(@RequestBody Description theDescription){

        return descriptionService.addUser(theDescription);

    }
    @PutMapping("/update")
    public Description updateEmployee(@RequestBody Description theDescription) {

        return descriptionService.updateUser(theDescription);
    }

    @DeleteMapping("/delete/{id}")
    public Description deleteUser(@PathVariable Long id){
        return descriptionService.deleteUser(id);
    }

    @RequestMapping(value ="/pagination")
    public Page<Description> Pagination(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        return descriptionService.getDescriptionPagination(pageNumber,pageSize);
    }


    @GetMapping("/getCaseDetails")
//    @ResponseBody
    public ResponseEntity<Map> getCaseDetails(@RequestParam (name = "Id") String Id, @RequestParam(value="details",required = false) String details){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
//        try{
            if(details != null){
                String []words = details.split(",");
                for(String field:words){
                    if(field.equals("Stagging"))
                        map1.put("Stagging",descriptionService.getCaseDetailsForStagging(Id,field));
                    if(field.equals("Dispatch"))
                        map1.put("Dispatch",descriptionService.getCaseDetailsForDispatch(Id,field));
                    if(field.equals("Planning"))
                        map1.put("Planning",descriptionService.getCaseDetailsForPlanning(Id,field));
                    if(field.equals("Account"))
                        map1.put("Account",descriptionService.getCaseDetailsForAccount(Id,field));
                    if(field.equals("ThreeDPrinting"))
                        map1.put("ThreeDPrinting",descriptionService.getCaseDetailsForThreeDPrinting(Id,field));
                }
                map.put("status",200);
                map.put("Data",map1);
            }
            else{
                log.info("inside everyone---->");
                System.out.println("everybody");
                map1.put("Stagging",descriptionService.getCaseDetailsForStagging(Id,"Stagging"));
                map1.put("Dispatch",descriptionService.getCaseDetailsForDispatch(Id,"Dispatch"));
                map1.put("Planning",descriptionService.getCaseDetailsForPlanning(Id,"Planning"));
                map1.put("Account",descriptionService.getCaseDetailsForAccount(Id,"Account"));
                map1.put("ThreeDPrinting",descriptionService.getCaseDetailsForThreeDPrinting(Id,"ThreeDPrinting"));
            }
                map.put("status",200);
                map.put("Data11",map1);

//        }
//        catch(Exception e){
//            throw new RuntimeException("There is an error-->"+e.getMessage());
//        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
