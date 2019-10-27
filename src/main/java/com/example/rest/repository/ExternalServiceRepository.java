package com.example.rest.repository;

import com.example.rest.model.exs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExternalServiceRepository extends JpaRepository<exs,Integer> {


}
