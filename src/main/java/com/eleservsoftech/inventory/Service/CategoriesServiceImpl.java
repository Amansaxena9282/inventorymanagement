package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.CategoriesRepository;
import com.eleservsoftech.inventory.entity.Categories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoriesServiceImpl implements CategoriesService{


    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public List<Categories> getAll() {
        log.info("CategoriesServiceImpl.getAll:ip:"+" ");
        List<Categories> result=null;
        try{
            result = categoriesRepository.findAll();
        }
        catch(Exception e){
            log.error("CategoriesServiceImpl.getAll:error="+e.getMessage());
        }
        return result;
    }

//    @Override
//    public List<Categories> getAll() {
//        log.info("CategoriesServiceImpl.getAll:ip:"+" ");
//        List<Categories> result=null;
//        try{
//            Categories categories = (Categories) categoriesRepository.findAll();
//           result = categories.getIsdelete(false);
//        }
//        catch(Exception e){
//            log.error("CategoriesServiceImpl.getAll:error="+e.getMessage());
//        }
//        return result;
//    }

    @Override
    public Categories addUser(Categories categories) {
        log.info("Categories service:save-->");
        Categories result = null;
        try{
            result = categoriesRepository.save(categories);
        }
        catch(Exception e){
            log.error("categories service:error="+e.getMessage());
        }
        return result;
    }

    @Override
    public Categories updateUser(Categories categories) {
        log.info("categories service:update -->");
        Categories result = null;
        try{
            Categories categories1 = categoriesRepository.getById(categories.getC_id());
            if(categories.getName() != null)
                categories1.setName(categories.getName());
            if(categories.getCreated_by()!=null)
                categories1.setCreated_by(categories.getCreated_by());
            if(categories.getLast_Modified_by()!=null)
                categories1.setLast_Modified_by(categories.getLast_Modified_by());
            if(categories.getIsdelete()!=null)
                categories1.setIsdelete(categories.getIsdelete());
            result =  categoriesRepository.save(categories1);

        }
        catch(Exception e){
            log.error("Categories serice :error="+e.getMessage());
        }

        return result;
    }

    @Override
    public Categories findById(Long theId) {
        log.info("categories service :findById-->");
        Optional<Categories> result = categoriesRepository.findById(theId);
        Categories categories = null;
        try{
            if(result.isPresent()) {
                categories = result.get();
            } else {
                throw new RuntimeException("Did not find the id-"+theId);
            }
        }catch(Exception e){
            log.error("Categories service :error-->"+e.getMessage());
        }
        return categories;
    }

    @Override
    public Categories getById2(Long id) {
        return categoriesRepository.findById(id).get();
    }

    @Override
    public Categories deleteUser(Long id) {
        Categories categories1 = null;
        try{
            Categories categories = categoriesRepository.getById(id);
            if(categories.getIsdelete() != null)
                categories.setIsdelete(true);
            else
                categories.setIsdelete(false);
            categories1 = categoriesRepository.save(categories);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return categories1;
    }

    @Override
    public Page<Categories> getCategoriesPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return categoriesRepository.findAll(pageable);
    }

}
