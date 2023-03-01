package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.CategoriesRepository;
import com.eleservsoftech.inventory.Repository.DescriptionRepository;
import com.eleservsoftech.inventory.Repository.MaterialRepository;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Description;
import com.eleservsoftech.inventory.entity.Material;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class MaterialServiceImpl implements MaterialService{
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private DescriptionService descriptionService;
    @Autowired
    private CategoriesService categoriesService;


//    @Override
//    public List<Material> getAll() {
////        Log.info("Material service Implementation");
//        log.info("Material Service Implementation:getAll--->");
//        List<Material> result= null;
//        List<Material> result1 = new ArrayList<>();
//        try{
//            result = materialRepository.findAll();
//        }
//        catch(Exception e){
//            log.error("Material Service Impl:error-->"+e.getMessage());
//        }
//        return result;
//    }

//    @Override
//    public List<Material> getAll() {
////        Log.info("Material service Implementation");
//        log.info("Material Service Implementation:getAll--->");
//        List<Material> result= null;
//        List<Material> result1 = new ArrayList<>();
//        try{
//            result = materialRepository.findAll();
//            if(result.size()>0){
//                for(Material material: result){
////                   Description description = descriptionService.findById(material.getDescription_id().longValue());
////                   Description description1 = descriptionService.findById(material.getDescription_id().longValue());
////                   Description description =  descriptionService.findById(material.getDescription_id().longValue());
////                    Categories categories = categoriesService.findById(data.getC_id().longValue());
////                        data.setCategoriesName(categories.getName());
////                        material.setDescriptionName(description);
////                       log.info("---->"+description);
////                        material.setDescriptionName((description.getName()));
//                    Description description = new Description();
//                    Categories categories = new Categories();
//                    if(material.getC_id()!=null && material.getDescription_id()!=null)
//                   categories =  Optional.ofNullable(categoriesService.findById(material.getC_id().longValue())).orElse(new Categories());
////                   description = Optional.ofNullable(descriptionService.findById(material.getDescription_id().longValue())).orElse(new Description());
////                   if(description!=null)
////                       material.setDescriptionName(description.getName());
//                    if(categories!=null  )
//                        material.setCategoriesName(categories.getName());
//                        result1.add(material);
//                    }
//                }
//        }
//        catch(Exception e){
//            log.error("Material Service Impl:error-->"+e.getMessage());
//        }
//        return result1;
//    }

    @Override
    public List<Material> getAll() {
        log.info("Material Service Implementation:getAll--->");
        List<Material> result= null;
        List<Material> result1 = new ArrayList<>();
        try{
            result = materialRepository.findAll();
            if(result.size()>0){
                for(Material material:result){
                    Categories categories = new Categories();
                    Description description = new Description();

                    if(material.getC_id()!=null && material.getDescription_id()!=null){
                        categories = Optional.ofNullable(categoriesService.findById(material.getC_id().longValue())).orElse(new Categories());
                        description = Optional.ofNullable(descriptionService.findById(material.getDescription_id().longValue())).orElse(new Description());
                        if(categories!=null)
                            material.setCategoriesName(categories.getName());
                         if(description!=null)
                            material.setDescriptionName(description.getName());
                        result1.add(material);
                    }
                }
            }
        }
        catch(Exception e){
            log.error("material service implement:error-->"+e.getMessage());
        }
        return result1;
    }

    @Override
    public Material addUser(Material material) {
        log.info("Material service impl :add-->");
        Material result = null;
        try{
            result = materialRepository.save(material);
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->"+e.getMessage());
        }
        return result;
    }

    @Override
    public Material updateUser(Material material) {
        log.info("Material service impl :update-->");
        Material result = null;
        try{
            Material material1 = materialRepository.getById(material.getM_id());
            if(material.getName() != null)
                material1.setName(material.getName());
            if(material.getC_id()!=null)
                material1.setC_id(material.getC_id());
            if(material.getCreated_by() != null)
                material1.setCreated_by(material.getCreated_by());
            if(material.getLast_Modified_by()!=null)
                material1.setLast_Modified_by(material.getLast_Modified_by());
            if(material.getIsdelete()!= null)
                material1.setIsdelete(material.getIsdelete());
            if(material.getDescription_id()!=null)
                material1.setDescription_id(material.getDescription_id());
            if(material.getDimension()!=null)
                material1.setDimension(material.getDimension());
            result = materialRepository.save(material1);
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->"+e.getMessage());
        }

        return result;
    }

//    @Override
//    public Material findById(Long theId) {
//        log.info("Material service impl :findById-->");
//        Optional<Material> result = materialRepository.findById(theId);
//        Material material = null;
//        try {
//            if (result.isPresent()) {
//                material = result.get();
//            } else {
//                throw new RuntimeException("Did not find the id-" + theId);
//            }
//        }
//            catch(Exception e){
//                log.error("Material Service Impl:error-->" + e.getMessage());
//            }
//
//        return material;
//    }

    @Override
    public Material findById(Long theId) {
        log.info("Material service impl :findById-->");
        Optional<Material> result;
        Material material = new Material();
        try {
            result = materialRepository.findById(theId);
            if (result.isPresent()) {
                material = result.get();
                Categories categories = new Categories();
                Description description = new Description();
                if(material.getC_id()!=null && material.getDescription_id()!=null){
                 categories = Optional.ofNullable(categoriesService.findById(material.getC_id().longValue())).orElse(new Categories());
                 description = Optional.ofNullable(descriptionService.findById(material.getDescription_id().longValue())).orElse(new Description());
                 if(categories!=null)
                     material.setCategoriesName(categories.getName());
                 if(description!=null)
                     material.setDescriptionName(description.getName());

                }
            }
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->" + e.getMessage());
        }

        return material;
    }

    @Override
    public Material deleteUser(Long id) {
        Material material1 = null;
        try{
            Material material = materialRepository.getById(id);
            if(material.getIsdelete() != null)
                material.setIsdelete(true);
            else
                material.setIsdelete(false);
            material1 = materialRepository.save(material);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return material1;
    }
    @Override
    public Page<Material> getMaterialPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return materialRepository.findAll(pageable);
    }
}


