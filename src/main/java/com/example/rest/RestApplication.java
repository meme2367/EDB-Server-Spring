package com.example.rest;

import com.example.rest.model.exs;
import com.example.rest.repository.ExternalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    @Autowired
    ExternalServiceRepository externalServiceRepository;

    public static void main(String[] args) {

        SpringApplication.run(RestApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {

        externalServiceRepository.save(new exs("열공백배1", "https://www.naver1.com"));

        externalServiceRepository.save(new exs("열공백배2", "https://www.naver2.com"));

        externalServiceRepository.save(new exs("열공백배3", "https://www.naver3.com"));

        externalServiceRepository.save(new exs("열공백배4", "https://www.naver4.com"));

        externalServiceRepository.save(new exs("열공백배5", "https://www.naver5.com"));

    }

}
