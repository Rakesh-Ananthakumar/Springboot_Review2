package com.example.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.realestate.model.Buy;

import com.example.realestate.service.BuyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class BuyController {
    public BuyService buyService;
    public BuyController(BuyService buyService)
    {
        this.buyService = buyService;
    }
    @PostMapping("/buy")
    public ResponseEntity<Buy> postMethodName(@RequestBody Buy buy) {
        
        if(buyService.saveNewRecord(buy)==true)
        {
            return new ResponseEntity<>(buy,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(buy,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/buydetails")
    public ResponseEntity<List<Buy>> getMethodName() {
        List<Buy> list =  buyService.getBuyDetails();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @PutMapping("/buy/{id}")
    public ResponseEntity<Buy> putMethodName(@PathVariable int id, @RequestBody Buy buy) {
        if(buyService.updateBuy(id,buy) == true)
        {
            return new ResponseEntity<>(buy,HttpStatus.OK);
        }
        return new ResponseEntity<>(buy,HttpStatus.NOT_FOUND);
        
    }

    @DeleteMapping("/buy/{id}")
    public ResponseEntity<Buy> delete(@PathVariable("id") int id)
    {
        if(buyService.deleteBuy(id)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @GetMapping("/buy/sortBy/{field}")
    public ResponseEntity<List<Buy>> getSortedList(@PathVariable("field")  String field) {
        List<Buy> list=buyService.sortByField(field);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/buy/sortByDesc/{field}")
    public ResponseEntity<List<Buy>> getSortedDesc(@PathVariable("field")  String field) {
        List<Buy> list=buyService.sortByDesc(field);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/buypagination/{offset}/{pagesize}")
    public ResponseEntity<List<Buy>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Buy> list = buyService.getPaginationBuy(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/buypagesort/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Buy>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<Buy> list = buyService.getSortedPagination(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/buyByPlace/{place}")
    public ResponseEntity<List<Buy>> getMethodPlace(@PathVariable("place") String place) {
        List<Buy> list = buyService.getBuyByPlace(place);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/buyByProperty/{property}")
    public ResponseEntity<List<Buy>> getMethodProperty(@PathVariable("property") String property) {
        List<Buy> list = buyService.getBuyByProperty(property);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    

}
