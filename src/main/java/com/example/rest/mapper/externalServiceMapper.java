package com.example.rest.mapper;

import com.example.rest.model.externalService;
import com.example.rest.model.externalServiceDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface externalServiceMapper {

   public List<externalService> getAvailableExternalService();

   public int insertExternalService(String name,String url);

   public List<externalService> getExternalServiceByName(String name);

   public int insertExternalServiceDetail(String externalServiceDetailNames,int externalServiceIdx);
}
