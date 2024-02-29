package com.example.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.realestate.model.Register;
import com.example.realestate.repository.RegisterRepository;

@Service
public class RegisterService {
    public RegisterRepository registerRepository;
    public RegisterService(RegisterRepository registerRepository)
    {
        this.registerRepository = registerRepository;
    }
    public boolean saveDetails(Register register)
    {
        try
        {
            registerRepository.save(register);
        } 
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Register> getDetails()
    {
        return registerRepository.findAll();
    }
    public boolean updatePassword(String email,Register register)
    {
        if(getDetailsbyId(email) == null)
        {
            System.out.println("\n Email not Found \n");
            return false;
        }
        try
        {
            registerRepository.save(register);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteDetails(String email)
    {
        if(this.getDetailsbyId(email)==null)
        {
            return false;
        }
        registerRepository.deleteById(email);
        return true;
    }
    public Register getDetailsbyId(String email)
    {
        Optional<Register> obj = registerRepository.findById(email);
        return obj.orElse(null);
    }

}
