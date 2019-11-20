package com.example.rest.controller;

import com.example.rest.dto.simpleResponse;
import com.example.rest.model.user;
import com.example.rest.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class userController {

    @Autowired
    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

//login
    @PostMapping("/signin")
    public simpleResponse signin(@RequestBody user user) {
        return userService.signin(user);
    }

    //signup
    //    const { id, passwd, email} = req.body;
    //
    //    var grade = 'USER';
    //
    //    if(req.body.grade){
    //        console.log(req.body.grade);
    //        grade = req.body.grade;
    //    }
    @PostMapping("/signup")
    public simpleResponse signup(@RequestBody user user){
        return userService.signup(user);
    }


}

