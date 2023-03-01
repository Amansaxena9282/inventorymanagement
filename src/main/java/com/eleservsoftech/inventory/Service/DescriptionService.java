package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Model.*;
import com.eleservsoftech.inventory.entity.Description;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DescriptionService {
    public List<Description> getAll();
    public Description addUser(Description description);

    public Description updateUser(Description description);

    public Description findById(Long theId);


    public List<Account> getCaseDetailsForAccount(String Id, String details);

    public List<Planning> getCaseDetailsForPlanning(String Id, String details);

    public List<Stagging> getCaseDetailsForStagging(String Id, String details);

    public List<DispatchedScan> getCaseDetailsForDispatch(String Id, String details);

    public List<ThreeDPrinting> getCaseDetailsForThreeDPrinting(String Id, String details);

    public Description deleteUser(Long id);

    public Page<Description> getDescriptionPagination(Integer pageNumber,Integer pageSize);

}
