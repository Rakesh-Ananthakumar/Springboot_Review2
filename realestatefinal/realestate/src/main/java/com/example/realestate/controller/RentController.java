package com.example.realestate.controller;
import org.springframework.web.bind.annotation.RestController;


import com.example.realestate.model.Rent;
import com.example.realestate.service.RentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class RentController {
    private RentService rentService;
    public RentController(RentService rentService)
    {
        this.rentService=rentService;
    }
    @PostMapping("/rent")
    public ResponseEntity<Rent> postRentDetails(@RequestBody Rent rent) {
        if(rentService.saveRent(rent) == true)
            return new ResponseEntity<>(rent,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/rents")
    public ResponseEntity<List<Rent>> getRentDetails() {
        List<Rent> list=rentService.rentDetails();
        if(list.size() == 0)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @PutMapping("/updaterent/{propertyId}")
    public ResponseEntity<Rent> updateDetails(@PathVariable("propertyId") int id, @RequestBody Rent rent) {
        if(rentService.updateRentDetails(id, rent) == true)
            return new ResponseEntity<>(rent,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletedetails/{productId}")
    public ResponseEntity<Rent> deleteProperty(@PathVariable("productId") int id)
    {
        if(rentService.deleteProperty(id) == true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/rent/sortBy/{field}")
    public ResponseEntity<List<Rent>> getSortedList(@PathVariable("field")  String field) {
        List<Rent> list=rentService.sortByField(field);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/rent/sortByDesc/{field}")
    public ResponseEntity<List<Rent>> getSortedDesc(@PathVariable("field")  String field) {
        List<Rent> list=rentService.sortByDesc(field);
        if(list.size() == 0)
            return new ResponseEntity<>(list,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/rentpagination/{offset}/{pagesize}")
    public ResponseEntity<List<Rent>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Rent> list = rentService.getPaginationBuy(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/rentpagesort/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Rent>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<Rent> list = rentService.getSortedPagination(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/rentByPlace/{place}")
    public ResponseEntity<List<Rent>> getMethodPlace(@PathVariable("place") String place) {
        List<Rent> list = rentService.getRentByPlace(place);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/rentByProperty/{property}")
    public ResponseEntity<List<Rent>> getMethodProperty(@PathVariable("property") String property) {
        List<Rent> list = rentService.getRentByProperty(property);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
}







