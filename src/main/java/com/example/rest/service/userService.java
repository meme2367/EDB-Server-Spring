package com.example.rest.service;

import com.example.rest.dto.simpleResponse;
import com.example.rest.mapper.userMapper;
import com.example.rest.model.user;
import com.example.rest.util.SHA256;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Slf4j
@Service
public class userService {

    @Autowired
    userMapper userMapper;

    @Autowired
    private jwtService jwtService;


    public simpleResponse signin(user user) {

        try {
            String id = user.getId();//ok
            user myUser = userMapper.getUserById(id);//ok

            if(myUser == null){
                return simpleResponse.FAIL;
            }

            String hashPassword = SHA256.getInstance().encodeSHA256(myUser.getSalt() + user.getPasswd());

            if(hashPassword.equals(myUser.getPasswd())){
                final jwtService.TokenResponse token
                        = new jwtService.TokenResponse(jwtService.create(myUser.getIdx(),myUser.getGrade()));

            //User response token
                System.out.println(token.getToken());

                return simpleResponse.SUCCESS;

            }else{
                return simpleResponse.FAIL;
            }

        }catch(Exception e){
            return simpleResponse.FAIL;

        }

    }

    public simpleResponse signup(user user) {

        try {
            String id = user.getId();
            user myUser = userMapper.getUserById(id);


            if(myUser == null) {
                System.out.print("\ncheck\n");

                SecureRandom secRan = SecureRandom.getInstance("SHA1PRNG");
                int numLength = 16;
                String salt = "";
                for (int i = 0; i < numLength; ++i) {
                    salt += secRan.nextInt(10);
                }

                String newPasswd = salt + user.getPasswd();
                String hassedPasswd = (SHA256.getInstance()).encodeSHA256(newPasswd);

                user.setSalt(salt);
                user.setPasswd(hassedPasswd);

                int result = userMapper.insertUser(user);
                System.out.print("\nresult\n");
                System.out.print(result);

                return result > 0 ? simpleResponse.SUCCESS : simpleResponse.FAIL;


            }else{
                return simpleResponse.FAIL;
            }
        }catch(Exception e){
            return simpleResponse.FAIL;

        }
    }
}