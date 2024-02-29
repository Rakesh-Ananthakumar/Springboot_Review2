package com.example.realestate.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.realestate.model.Rent;
import com.example.realestate.repository.RentRepository;

@Service
public class RentService {
    private RentRepository rentRepository;
    public RentService(RentRepository rentRepository)
    {
        this.rentRepository=rentRepository;
    }
    public boolean saveRent(Rent rent)
    {
        try
        {
            rentRepository.save(rent);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    public List<Rent> rentDetails()
    {
        return rentRepository.findAll();
    }
    
    public Rent getProductId(int id)
    {
        return rentRepository.findById(id).orElse(null);
    }
    
    public boolean updateRentDetails(int id,Rent rent)
    {
        if(this.getProductId(id) == null)
        {
            return false;
        }
        try
        {
            rentRepository.save(rent);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    public boolean deleteProperty(int id)
    {
        if(this.getProductId(id) == null)
            return false;
        rentRepository.deleteById(id);
        return true;
    }

    public List<Rent> sortByField(String field)
    {
        return rentRepository.findAll(Sort.by(field));
    }
    public List<Rent> sortByDesc(String field)
    {
        return rentRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    public List<Rent> getPaginationBuy(int offset,int size)
    {
        return rentRepository.findAll(PageRequest.of(offset, size)).getContent();                        
    }

    public List<Rent> getSortedPagination(int offset,int size,String field)
    {
        return rentRepository.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

    public List<Rent> getRentByPlace(String place)
    {
        return rentRepository.findByPlace(place);
    }
    public List<Rent> getRentByProperty(String property)
    {
        return rentRepository.findByProperty(property);
    }
}
