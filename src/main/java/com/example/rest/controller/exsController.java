package com.example.rest.controller;

import com.example.rest.model.exs;
import com.example.rest.repository.ExternalServiceRepository;
import com.example.rest.service.externelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class exsController{
    // 외부서비스입력

    @Autowired
    externelServices externelServices;


    @PostMapping
    public ResponseEntity<exs> save(@RequestBody exs emp) {
        return new ResponseEntity<exs>(externelServices.save(emp),HttpStatus.OK);
    }

    @GetMapping(path="/")
    public List<exs> getExs(){
        List<exs> ret = externelServices.findAll();
        return ret;
    }
}
