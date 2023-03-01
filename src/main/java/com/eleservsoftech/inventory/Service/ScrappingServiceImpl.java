package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.ScrappingRepository;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Description;
import com.eleservsoftech.inventory.entity.Material;
import com.eleservsoftech.inventory.entity.Scrapping;
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
public class ScrappingServiceImpl implements ScrappingService{
    @Autowired
    private ScrappingRepository scrappingRepository;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private CategoriesService categoriesService;


//    @Override
//    public List<Scrapping> getAll() {
//        log.info("Scrapping service Implementation:getAll-->");
//        List<Scrapping> result = null;
//        try{
//            result = scrappingRepository.findAll();
//        }
//        catch(Exception e){
//            log.error("Scrapping service impl:error-->"+e.getMessage());
//        }
//        return result;
//    }

//    @Override
//    public List<Scrapping> getAll() {
//        log.info("Scrapping service Implementation:getAll-->");
//        List<Scrapping> result = null;
//        List<Scrapping> result1 = new ArrayList<>();
//        try {
//            result = scrappingRepository.findAll();
//            if(result.size()>0){
//                for(Scrapping scrapping:result)
//                {
////                    Material material = materialService.findById(scrapping.getM_id().longValue());
//                    Categories categories = categoriesService.findById(scrapping.getC_id().longValue());
//                    if(  categories!=null){  //&&material!=null
////                        scrapping.setMaterialName(material.getName());
//                        scrapping.setCategoriesName(categories.getName());
//                        result1.add(scrapping);
//                    }
//                }
//            }
//
//        }
//        catch(Exception e){
//            log.error("Scrapping service impl:error-->"+e.getMessage());
//        }
//        return result1;
//    }

    @Override
    public List<Scrapping> getAll() {
        log.info("Scrapping service Implementation:getAll-->");
        List<Scrapping> result = null;
        List<Scrapping> result1 = new ArrayList<>();

        try{
            result = scrappingRepository.findAll();
            if(result.size()>0){
                for(Scrapping scrapping: result){
                    Categories categories = new Categories();
                    Material material = new Material();

                    if(scrapping.getC_id()!=null && scrapping.getM_id()!=null){
                        categories = Optional.ofNullable(categoriesService.findById(scrapping.getC_id().longValue())).orElse(new Categories());
                        material = Optional.ofNullable(materialService.findById(scrapping.getM_id().longValue())).orElse(new Material());

                        if(categories!=null)
                            scrapping.setCategoriesName(categories.getName());
                        if(material!=null)
                            scrapping.setMaterialName(material.getName());

                        result1.add(scrapping);
                    }
                }
            }
        }
        catch(Exception e){
            log.error("Scrapping service implement:error-->"+e.getMessage());
        }
        return result1;
    }

    @Override
    public Scrapping addUser(Scrapping scrapping) {
        log.info("Scrapping service Implementation:add-->");
        Scrapping result = null;
        try{
            result=scrappingRepository.save(scrapping);
        }
        catch(Exception e){
            log.error("Scrapping service impl:error-->"+e.getMessage());
        }
        return result;
    }

    @Override
    public Scrapping updateUser(Scrapping scrapping) {
        log.info("Scrapping service Implementation:update-->");
        Scrapping result = null;
        try{
            Scrapping scrapping1 = scrappingRepository.getById(scrapping.getScrapping_id());
            if(scrapping.getSin_id() != null)
                scrapping1.setSin_id(scrapping.getSin_id());
            if(scrapping.getCreated_by() != null)
                scrapping1.setCreated_by(scrapping.getCreated_by());
            if(scrapping.getQuantity()!=null)
                scrapping1.setQuantity(scrapping.getQuantity());
            if(scrapping.getScrapped()!=null)
                scrapping1.setScrapped(scrapping.getScrapped());
            if(scrapping.getMenufacture_lot_no()!=null)
                scrapping1.setMenufacture_lot_no(scrapping.getMenufacture_lot_no());
            if(scrapping.getVendor_lot_no()!=null)
                scrapping1.setVendor_lot_no(scrapping.getVendor_lot_no());
            if(scrapping.getIssued_by()!=null)
                scrapping1.setIssued_by(scrapping.getIssued_by());
            if(scrapping.getIssued_to()!=null)
                scrapping1.setIssued_to(scrapping.getIssued_to());
            if(scrapping.getM_id() != null)
                scrapping1.setM_id(scrapping.getM_id());
            if(scrapping.getC_id() != null)
                scrapping1.setC_id(scrapping.getC_id());
            if(scrapping.getCreated_by() != null)
                scrapping1.setCreated_by(scrapping.getCreated_by());
            if(scrapping.getLast_Modified_by() != null)
                scrapping1.setLast_Modified_by(scrapping.getLast_Modified_by());
            if(scrapping.getIsdelete()!=null)
                scrapping1.setIsdelete(scrapping.getIsdelete());
            if(scrapping.getPrice()!=null)
                scrapping1.setPrice(scrapping.getPrice());
            result =scrappingRepository.save(scrapping1);
        }
        catch(Exception e){
            log.error("Scrapping Service Impl:error"+e.getMessage());
        }

        return result;
    }

//    @Override
//    public Scrapping findById(Long theId) {
//        log.info("Scrapping service Implementation:findById-->");
//        Optional<Scrapping> result = scrappingRepository.findById(theId);
//        Scrapping scrapping = null;
//        try{
//            if(result.isPresent()) {
//                scrapping = result.get();
//            }
//            else {
//                throw new RuntimeException("Did not find the id-"+theId);
//            }
//        }
//            catch(Exception e){
//                log.error("Scrapping service impl:error-->"+e.getMessage());
//            }
//        return scrapping;
//    }

    @Override
    public Scrapping findById(Long theId) {
        log.info("Material service impl :findById-->");
        Optional<Scrapping> result;
        Scrapping scrapping = new Scrapping();
        try {
            result = scrappingRepository.findById(theId);
            if (result.isPresent()) {
                scrapping = result.get();
                Categories categories = new Categories();
                Material material = new Material();
                if(scrapping.getC_id()!=null && scrapping.getM_id()!=null){
                    categories = Optional.ofNullable(categoriesService.findById(scrapping.getC_id().longValue())).orElse(new Categories());
                    material = Optional.ofNullable(materialService.findById(scrapping.getM_id().longValue())).orElse(new Material());
                    if(categories!=null)
                        scrapping.setCategoriesName(categories.getName());
                    if(material!=null)
                        scrapping.setMaterialName(material.getName());

                }
            }
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->" + e.getMessage());
        }

        return scrapping;
    }

    @Override
    public Scrapping deleteUser(Long id) {
        Scrapping scrapping1 = null;
        try{
            Scrapping scrapping = scrappingRepository.getById(id);
            if(scrapping.getIsdelete() != null)
                scrapping.setIsdelete(true);
            else
                scrapping.setIsdelete(false);
            scrapping1 = scrappingRepository.save(scrapping);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return scrapping1;

    }

    @Override
    public Page<Scrapping> getScrappingPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return scrappingRepository.findAll(pageable);
    }


}
