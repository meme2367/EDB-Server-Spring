package com.example.rest.service;

import com.example.rest.model.exs;
import com.example.rest.repository.ExternalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class externelServices {

    @Autowired
    private  ExternalServiceRepository externalServiceRepository;



    public List<exs> findAll(){
        List<exs> ext = new ArrayList<>();
        externalServiceRepository.findAll().forEach(e-> ext.add(e));
        return ext;
    }

    public exs createExs(exs exs){
        exs res = externalServiceRepository.save(exs);
        return res;
    }

    public void updateExs(int id,exs exs){
        externalServiceRepository.findById((int)id)
                .map(e -> {
                    e.setName(exs.getName());
                    e.setUrl(exs.getUrl());
                    return externalServiceRepository.save(e);
                }).orElseGet((()->{
                    exs.setId((int)id);
                    return externalServiceRepository.save(exs);
        }));
    }

    public  exs save(exs emp) {
        externalServiceRepository.save(emp);
        return emp;

    }


    public void deleteExs(int id){
        externalServiceRepository.deleteById(id);
    }
}
