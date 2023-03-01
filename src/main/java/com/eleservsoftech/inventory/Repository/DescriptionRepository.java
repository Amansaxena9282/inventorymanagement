package com.eleservsoftech.inventory.Repository;

import com.eleservsoftech.inventory.Model.Account;
import com.eleservsoftech.inventory.Model.DispatchedScan;
import com.eleservsoftech.inventory.Model.Planning;
import com.eleservsoftech.inventory.Model.Stagging;
import com.eleservsoftech.inventory.Model.ThreeDPrinting;
import com.eleservsoftech.inventory.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DescriptionRepository extends JpaRepository<Description,Long>{


    @Query(value="call case_details(?1,?2)",nativeQuery = true)
    public List<DispatchedScan> getCaseDetailsForDispatch(String Id, String details);

    @Query(value="call case_details(?1,?2)",nativeQuery = true)
    public List<Account> getCaseDetailsForAccount(String Id, String details);

    @Query(value="call case_details(?1,?2)",nativeQuery = true)
    public List<Planning> getCaseDetailsForPlanning(String Id, String details);

    @Query(value="call case_details(?1,?2)",nativeQuery = true)
    public List<Stagging> getCaseDetailsForStagging(String Id, String details);

    @Query(value="call case_details(?1,?2)",nativeQuery = true)
    public List<ThreeDPrinting> getCaseDetailsForThreeDPrinting(String Id, String details);


}
