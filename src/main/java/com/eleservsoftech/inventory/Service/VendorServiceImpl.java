package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.VendorRepository;
import com.eleservsoftech.inventory.entity.Vendor;
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
public class VendorServiceImpl implements VendorService{
    @Autowired
    private VendorRepository vendorRepository;
    @Override
    public List<Vendor> getAll() {
        log.info("Vendor Service Implementation -->");
        List<Vendor> result = new ArrayList<>();
        try{
        result= vendorRepository.findAll();
        }
        catch (Exception e){
            log.error("Vendor service:error="+e.getMessage());
        }
        return result;
    }

    @Override
    public Vendor addUser(Vendor vendor) {
        log.info("Vendor Service Implementation -->");
        Vendor result = null;
        try{
            result = vendorRepository.save(vendor);
        }
        catch(Exception e){
            log.error("Total stock_out service Implementation :error"+e.getMessage());
        }

        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor updateUser(Vendor vendor) {
        log.info("Vendor Service Implementation -->");
          Vendor result = null;
        try{
            Vendor vendor1 = vendorRepository.getById(vendor.getVendor_id());
            if(vendor.getVendor_Code()!=null)
                vendor1.setVendor_Code(vendor.getVendor_Code());
            if(vendor.getName()!=null)
                vendor1.setName(vendor.getName());
            if(vendor.getCreated_by()!=null)
                vendor1.setCreated_by(vendor.getCreated_by());
            if(vendor.getLast_Modified_by()!=null)
                vendor1.setLast_Modified_by(vendor.getLast_Modified_by());
            if(vendor.getIsdelete()!=null)
                vendor1.setIsdelete(vendor.getIsdelete());
            result = vendorRepository.save(vendor1);
        }
        catch(Exception e){
            log.error("Total stock_out service Implementation :error"+e.getMessage());
        }

        return result;
    }

    @Override
    public Vendor findById(Long theId) {
        log.info("Vendor Service Implementation -->");
        Optional<Vendor> result = vendorRepository.findById(theId);
        Vendor vendor = new Vendor();
        try{
            if(result.isPresent()) {
                vendor = result.get();
            }
            else {
                throw new RuntimeException("Did not find the id-"+theId);
            }
        }
        catch(Exception e){
            log.error("Total stock_out service Implementation :error"+e.getMessage());
        }

        return vendor;

    }

    @Override
    public Vendor deleteUser(Long id) {
        Vendor vendor1 = null;
        try{
            Vendor vendor = vendorRepository.getById(id);
            if(vendor.getIsdelete() != null)
                vendor.setIsdelete(true);
            else
                vendor.setIsdelete(false);
            vendor1 = vendorRepository.save(vendor);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return vendor1;
    }

    @Override
    public Page<Vendor> getVendorPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return vendorRepository.findAll(pageable);
    }

}
