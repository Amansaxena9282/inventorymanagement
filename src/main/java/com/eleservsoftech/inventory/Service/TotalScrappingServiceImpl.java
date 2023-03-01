package com.eleservsoftech.inventory.Service;

import com.eleservsoftech.inventory.Repository.TotalScrappingRepository;
import com.eleservsoftech.inventory.entity.TotalScrapping;
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
public class TotalScrappingServiceImpl implements TotalScrappingService {
    @Autowired
    private TotalScrappingRepository totalScrappingRepository;
    @Override
    public List<TotalScrapping> getAll() {
        log.info("Total Scrapping Service Implementation-->");
        List<TotalScrapping> result = null;
        try{
            result = totalScrappingRepository.findAll();
        }
        catch(Exception e){
            log.error("Total_scrapping Service Implementation : error"+e.getMessage());
        }
        return result;
    }

    @Override
    public TotalScrapping findById(Long Id) {
        log.info("Total scrapping service:findById-->");
        Optional<TotalScrapping> result = totalScrappingRepository.findById(Id);
        TotalScrapping totalScrapping = null;
        try{
            if(result.isPresent()) {
                totalScrapping = result.get();
            }
            else {
                throw new RuntimeException("Did not find the id-"+Id);
            }
        }
        catch(Exception e){
            log.error("Total_scrapping Service Implementation : error"+e.getMessage());
        }

        return totalScrapping;

    }

    @Override
    public Page<TotalScrapping> getTotal_scrapping(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return totalScrappingRepository.findAll(pageable);
    }
}
