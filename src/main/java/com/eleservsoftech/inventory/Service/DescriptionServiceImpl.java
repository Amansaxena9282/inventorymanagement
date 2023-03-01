package com.eleservsoftech.inventory.Service;


import com.eleservsoftech.inventory.Model.*;
import com.eleservsoftech.inventory.Repository.DescriptionRepository;
import com.eleservsoftech.inventory.entity.Description;
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
public class DescriptionServiceImpl implements DescriptionService{
    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    public List<Description> getAll() {
        log.info("Description Service Implementation :getAll--->");
        List<Description> result = null;
        try{
            result=descriptionRepository.findAll();
        }
        catch(Exception e){
            log.error("DescriptionServiceImpl:error-->"+e.getMessage());
        }

        return result;
    }

    @Override
    public Description addUser(Description description) {
        log.info("Description service :add->");
        Description result = null;
        try{
            result = descriptionRepository.save(description);
        }
        catch(Exception e){
            log.error("description dervice :error-->"+e.getMessage());
        }

        return result;
    }

    @Override
    public Description updateUser(Description description) {
        log.info("Description service :update->");
        Description result = null;
        try{
            Description description1=descriptionRepository.getById(description.getDescription_id());
            if(description.getName() != null)
                description1.setName(description.getName());
            if(description.getCreated_by() != null)
                description1.setCreated_by(description.getCreated_by());
            if(description.getLast_modified_by()!=null)
                description1.setLast_modified_by(description.getLast_modified_by());
            if(description.getIsdelete()!=null)
                description1.setIsdelete(description.getIsdelete());
            result = descriptionRepository.save(description1);
        }
        catch(Exception e){
            log.error("description dervice :error-->"+e.getMessage());
        }

        return result;
    }

//    @Override
//    public Description findById(Long theId) {
//        Description des1 = descriptionRepository.getById(theId);
//        Description description = null;
//        if(des1.getDescription_id()==theId) {
//             description = des1;
//        }
//        else{
//            throw new RuntimeException("Did not find the id-"+theId);
//        }
//        return description;
//    }
@Override
public Description findById(Long theId) {
    log.info("Description service :findById->");
    Optional<Description> result = descriptionRepository.findById(theId);
    Description description = null;
    try{
        if(result.isPresent()) {
            description = result.get();
        }
        else {
            throw new RuntimeException("Did not find the id-"+theId);
        }
    }
    catch(Exception e){
        log.error("description dervice :error-->"+e.getMessage());
    }

    return description;
}

    @Override
    public List<Account> getCaseDetailsForAccount(String Id, String details) {
        return descriptionRepository.getCaseDetailsForAccount(Id,details);
    }

    @Override
    public List<Planning> getCaseDetailsForPlanning(String Id, String details) {
        return descriptionRepository.getCaseDetailsForPlanning(Id,details);
    }

    @Override
    public List<Stagging> getCaseDetailsForStagging(String Id, String details) {
        return descriptionRepository.getCaseDetailsForStagging(Id,details);
    }

    @Override
    public List<DispatchedScan> getCaseDetailsForDispatch(String Id, String details) {
        return descriptionRepository.getCaseDetailsForDispatch(Id,details);
    }

    @Override
    public List<ThreeDPrinting> getCaseDetailsForThreeDPrinting(String Id, String details) {
        return descriptionRepository.getCaseDetailsForThreeDPrinting(Id,details);
    }

    @Override
    public Description deleteUser(Long id) {
        Description description1 = null;
        try{
            Description description = descriptionRepository.getById(id);
            if(description.getIsdelete() != null)
                description.setIsdelete(true);
            else
                description.setIsdelete(false);
            description1 = descriptionRepository.save(description);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return description1;
    }

    @Override
    public Page<Description> getDescriptionPagination(Integer pageNumber, Integer pageSize)
    {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return descriptionRepository.findAll(pageable);
    }
}
