package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.StockOutRepository;
import com.eleservsoftech.inventory.entity.Categories;
import com.eleservsoftech.inventory.entity.Material;
import com.eleservsoftech.inventory.entity.Scrapping;
import com.eleservsoftech.inventory.entity.StockOut;
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
public class StockOutServiceImpl implements StockOutService {
    @Autowired
    private StockOutRepository stock_outRepository;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private CategoriesService categoriesService;


//    @Override
//    public List<StockOut> getAll() {
//        log.info("Stock_out Service Implementation-->");
//        List<StockOut> result = null;
//        try{
//            result = stock_outRepository.findAll();
//        }
//        catch(Exception e){
//            log.error("Stock_in Service Implementation : error"+e.getMessage());
//        }
//        return result;
//    }

    @Override
    public List<StockOut> getAll() {
        log.info("Stock_out Service Implementation-->");
        List<StockOut> result = null;
        List<StockOut> result1 = new ArrayList<>();
        try{
            result = stock_outRepository.findAll();
            if(result.size()>0){
                for(StockOut stock : result){
                    Material material = materialService.findById(stock.getM_id());
                    Categories categories = categoriesService.findById(stock.getC_id());
                    if(material!=null  && categories !=null){
                        stock.setMaterialName(material.getName());
                        stock.setCategoriesName(categories.getName());
                        result1.add(stock);
                    }
                }
            }
        }
        catch(Exception e){
            log.error("Stock_in Service Implementation : error"+e.getMessage());
        }
        return result1;
    }

    @Override
    public StockOut addUser(StockOut stock_out) {
        log.info("Stock_in service:add-->");
        StockOut result = null;
        try{
           result =stock_outRepository.save(stock_out);
        }
        catch(Exception e){
            log.error("Stock_in Service Implementation : error"+e.getMessage());
        }
        return result;
    }

    @Override
    public StockOut updateUser(StockOut stock_out) {
        log.info("Stock_in service:add-->");
        StockOut result = null;
        try{
            StockOut stock_out1=stock_outRepository.getById(stock_out.getSout_id());
            if(stock_out.getSin_id() != null)
                stock_out1.setSin_id(stock_out.getSin_id());
            if(stock_out.getM_id()!=null)
                stock_out1.setM_id(stock_out.getM_id());
            if(stock_out.getC_id()!=null)
                stock_out1.setC_id(stock_out.getC_id());
            if(stock_out.getCase_id()!=null)
                stock_out1.setC_id(stock_out.getC_id());
            if(stock_out.getQuantity()!=null)
                stock_out1.setQuantity(stock_out.getQuantity());
            if(stock_out.getStock_out()!=null)
                stock_out1.setStock_out(stock_out.getStock_out());
            if(stock_out.getMenufacture_lot_no()!=null)
                stock_out1.setMenufacture_lot_no(stock_out.getMenufacture_lot_no());
            if(stock_out.getVendor_lot_no()!=null)
                stock_out1.setVendor_lot_no(stock_out.getVendor_lot_no());
            if(stock_out.getIssued_by()!=null)
                stock_out1.setIssued_by(stock_out.getIssued_by());
            if(stock_out.getIssued_to()!=null)
                stock_out1.setIssued_to(stock_out.getIssued_to());
            if(stock_out.getCreated_by()!=null)
                stock_out1.setCreated_by(stock_out.getCreated_by());
            if(stock_out.getLast_Modified_by()!=null)
                stock_out1.setLast_Modified_by(stock_out.getLast_Modified_by());
            if(stock_out.getIsdelete()!=null)
                stock_out1.setIsdelete(stock_out.getIsdelete());
            if(stock_out.getPrice()!=null)
                stock_out1.setPrice(stock_out.getPrice());
            result = stock_outRepository.save(stock_out1);
        }
        catch(Exception e){
            log.error("Stock_in Service Implementation : error"+e.getMessage());
        }

        return result;
    }

//    @Override
//    public StockOut findById(Long theId) {
//        Optional<StockOut> result = stock_outRepository.findById(theId);
//        StockOut stock_out = null;
//        try{
//            if(result.isPresent()) {
//                stock_out = result.get();
//            }
//            else {
//                throw new RuntimeException("Did not find the id-"+theId);
//            }
//        }
//        catch(Exception e){
//            log.error("Stock_in Service Implementation : error"+e.getMessage());
//        }
//
//        return stock_out;
//    }

    @Override
    public StockOut findById(Long theId) {
        log.info("Material service impl :findById-->");
        Optional<StockOut> result;
        StockOut stockOut = new StockOut();
        try {
            result = stock_outRepository.findById(theId);
            if (result.isPresent()) {
                stockOut = result.get();
                Categories categories = new Categories();
                Material material = new Material();
                if(stockOut.getC_id()!=null && stockOut.getM_id()!=null){
                    categories = Optional.ofNullable(categoriesService.findById(stockOut.getC_id().longValue())).orElse(new Categories());
                    material = Optional.ofNullable(materialService.findById(stockOut.getM_id().longValue())).orElse(new Material());
                    if(categories!=null)
                        stockOut.setCategoriesName(categories.getName());
                    if(material!=null)
                        stockOut.setMaterialName(material.getName());

                }
            }
        }
        catch(Exception e){
            log.error("Material Service Impl:error-->" + e.getMessage());
        }

        return stockOut;
    }

    @Override
    public StockOut deleteUser(Long id) {
        StockOut stock_out1 = null;
        try{
            StockOut stock_out = stock_outRepository.getById(id);
            if(stock_out.getIsdelete() != null)
                stock_out.setIsdelete(true);
            else
                stock_out.setIsdelete(false);
            stock_out1 = stock_outRepository.save(stock_out);
        }
        catch(Exception e){
            throw new RuntimeException("An exception occured-->"+e.getMessage());
        }
//         categoriesRepository.deleteById(id);
        return stock_out1;
    }

    @Override
    public Page<StockOut> getCategoriesPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return stock_outRepository.findAll(pageable);
    }
//    @Override
//    public Page<Stock_out> getCategoriesPagination(Integer pageNumber, Integer pageSize) {
//        Sort sort = Sort.by(Sort.Direction.DESC,"sin_id");
//        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
//        return stock_outRepository.findAll(pageable);
//    }
}
