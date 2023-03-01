package com.eleservsoftech.inventory.Service;


import com.eleservsoftech.inventory.Repository.StockInRepository;
import com.eleservsoftech.inventory.entity.*;
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
public class StockInServiceImpl implements StockInService {
    @Autowired
    private StockInRepository stock_inRepository;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private VendorService vendorService;

    @Override
    public List<StockIn> getAll() {
        log.info("Stock_in service implementation:getAll-->");
        List<StockIn> result = null;
        List<StockIn> result1 = new ArrayList<>();
         try{
             result = stock_inRepository.findAll();
             if(result.size()>0){
                 for(StockIn stock:result){
//                     Categories categories = categoriesService.findById(stock.getC_id());
//                     Vendor vendor = vendorService.findById(stock.getVendor_id());
//                     Material material = materialService.findById(stock.getM_id());
                     Categories categories = new Categories();
                     Material material = new Material();
                     Vendor vendor=new Vendor();

                     if(stock.getVendor_id()!=null && stock.getM_id()!=null && stock.getC_id()!=null)

                     vendor=Optional.ofNullable(vendorService.findById(stock.getVendor_id())).orElse(new Vendor());
                     material = Optional.ofNullable(materialService.findById(stock.getM_id())).orElse(new Material());
                     categories = Optional.ofNullable(categoriesService.findById(stock.getC_id())).orElse(new Categories());
                     if(categories!=null)
                         stock.setCategoriesName(categories.getName());
                     if( vendor!=null )
                         stock.setVendorName(vendor.getName());
                     if(material!=null)
                         stock.setMaterialName(material.getName());

                         result1.add(stock);
                     }
                 }
         }
         catch(Exception e){
             log.error("Stock_in service implement:error-->"+e.getMessage());
        }

        return result1;
    }

    @Override
    public StockIn addUser(StockIn stock_in) {
        log.info("Stock_in service implementation:add-->");
        StockIn result = null;
        try{
            result = stock_inRepository.save(stock_in);
        }
        catch(Exception e){
            log.error("Stock_in service implement:error-->"+e.getMessage());
        }
        return result;
    }

    @Override
    public StockIn updateUser(StockIn stock_in) {
        log.info("Stock_in service implementation:update-->");
        StockIn result = null;
        try{
            StockIn stock_in1 = stock_inRepository.getById(stock_in.getSin_id());
            if(stock_in.getM_id()!=null)
                stock_in1.setM_id(stock_in.getM_id());
            if(stock_in.getC_id()!=null)
                stock_in1.setC_id(stock_in.getC_id());
            if(stock_in.getCreated_by() != null)
                stock_in1.setCreated_by(stock_in.getCreated_by());
            if(stock_in.getStock_in()!= null)
                stock_in1.setStock_in(stock_in.getStock_in());
            if(stock_in.getMenufacture_lot_no()!=null)
                stock_in1.setMenufacture_lot_no(stock_in.getMenufacture_lot_no());
            if(stock_in.getVendor_lot_no()!=null)
                stock_in1.setVendor_lot_no(stock_in.getVendor_lot_no());
            if(stock_in.getLast_Modified_by() != null)
                stock_in1.setLast_Modified_by(stock_in.getLast_Modified_by());
            if(stock_in.getIsdelete()!=null)
                stock_in1.setIsdelete(stock_in.getIsdelete());
            if(stock_in.getVendor_id()!=null)
                stock_in1.setVendor_id(stock_in.getVendor_id());
            if(stock_in.getQuantity() != null)
                stock_in1.setQuantity(stock_in.getQuantity());
            if(stock_in.getPrice()!=null)
                stock_in1.setPrice(stock_in.getPrice());
            result = stock_inRepository.save(stock_in1);
        }
        catch(Exception e){
            log.error("Stock_in service implement:error-->"+e.getMessage());
        }

        return result;
    }

//    @Override
//    public StockIn findById(Long theId) {
//        Optional<StockIn> result = stock_inRepository.findById(theId);
//        StockIn stock_in = null;
//        try{
//            if(result.isPresent()) {
//                stock_in = result.get();
//            }
//            else {
//                throw new RuntimeException("Did not find the id-"+theId);
//            }
//        }
//        catch(Exception e){
//            log.error("Stock_in service implement:error-->"+e.getMessage());
//        }
//
//        return stock_in;
//    }

    @Override
    public StockIn findById(Long theId) {
        log.info("Material service impl :findById-->");
        Optional<StockIn> result;
        StockIn stockIn = new StockIn();
        try {
            result = stock_inRepository.findById(theId);
            if (result.isPresent()) {
                stockIn = result.get();
                Categories categories = new Categories();
                Material material = new Material();
                Vendor vendor = new Vendor();
                if(stockIn.getC_id()!=null && stockIn.getM_id()!=null && stockIn.getVendor_id()!=null){
                    categories = Optional.ofNullable(categoriesService.findById(stockIn.getC_id().longValue())).orElse(new Categories());
                    material = Optional.ofNullable(materialService.findById(stockIn.getM_id().longValue())).orElse(new Material());
                    vendor = Optional.ofNullable(vendorService.findById(stockIn.getVendor_id().longValue())).orElse(new Vendor());
                    if(categories!=null)
                        stockIn.setCategoriesName(categories.getName());
                    if(material!=null)
                        stockIn.setMaterialName(material.getName());
                    if(vendor!=null)
                        stockIn.setVendorName(vendor.getName());

                }
            }
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->" + e.getMessage());
        }

        return stockIn;
    }

    @Override
    public StockIn deleteUser(Long id) {
        StockIn stock_in1 = null;
        try{
            StockIn stock_in = stock_inRepository.getById(id);
            if(stock_in.getIsdelete() != null)
                stock_in.setIsdelete(true);
            else
                stock_in.setIsdelete(false);
            stock_in1 = stock_inRepository.save(stock_in);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return stock_in1;

    }

    @Override
    public Page<StockIn> getStock_inPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return stock_inRepository.findAll(pageable);
    }
}
