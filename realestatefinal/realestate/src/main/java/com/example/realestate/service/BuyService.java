package com.example.realestate.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.realestate.model.Buy;

import com.example.realestate.repository.BuyRepository;

@Service
public class BuyService {
    private BuyRepository buyRepository;
    public BuyService(BuyRepository buyRepository)
    {
        this.buyRepository = buyRepository;
    }
    public boolean saveNewRecord(Buy buy)
    {
        try
        {
            buyRepository.save(buy);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Buy> getBuyDetails()
    {
        return buyRepository.findAll();
    }
    public boolean updateBuy(int id,Buy buy)
    {
        if(getBuyById(id)==null)
        {
            return false;
        }
        try{
            buyRepository.save(buy);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteBuy(int id)
    {
        if(getBuyById(id)==null)
        {
            return false;
        }
        buyRepository.deleteById(id);
        return true;
        
    }
    public Buy getBuyById(int id)
    {
        // Optional<Buy> obj = buyRepository.findById(id);
        // return obj.orElse(null);
        return buyRepository.findById(id).orElse(null);
    }

    public List<Buy> sortByField(String field)
    {
        return buyRepository.findAll(Sort.by(field));
    }
    public List<Buy> sortByDesc(String field)
    {
        return buyRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public List<Buy> getPaginationBuy(int offset,int size)
    {
        return buyRepository.findAll(PageRequest.of(offset, size)).getContent();                        
    }

    public List<Buy> getSortedPagination(int offset,int size,String field)
    {
        return buyRepository.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

    public List<Buy> getBuyByPlace(String place)
    {
        return buyRepository.findByPlace(place);
    }
    public List<Buy> getBuyByProperty(String property)
    {
        return buyRepository.findByProperty(property);
    }
}




