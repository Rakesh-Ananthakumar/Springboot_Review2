package com.example.realestate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.realestate.model.Register;
import com.example.realestate.service.RegisterService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class RegisterController {
    public RegisterService registerService;
    public RegisterController(RegisterService registerService)
    {
        this.registerService = registerService;
    }
    @PostMapping("/register")
    public ResponseEntity<Register> postMethodName(@RequestBody Register register) {
        if(registerService.saveDetails(register)==true)
        {
            return new ResponseEntity<>(register,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(register,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/registers")
    public ResponseEntity<List<Register>> getMethodName() {
        List<Register> list =  registerService.getDetails();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @PutMapping("/register/{email}")
    public ResponseEntity<Register> putMethodName(@PathVariable("email") String email, @RequestBody Register register) {
        if(registerService.updatePassword(email,register) == true)
        {
            return new ResponseEntity<>(register,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(register,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/register/{email}")
    public ResponseEntity<Register> delete(@PathVariable("email") String mail)
    {
        if(registerService.deleteDetails(mail)==true)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


