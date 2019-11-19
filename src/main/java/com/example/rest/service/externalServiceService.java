package com.example.rest.service;



import com.example.rest.dto.simpleResponse;
import com.example.rest.mapper.externalServiceMapper;
import com.example.rest.model.externalService;
import com.example.rest.model.externalServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * Service class : 비지니스 로직이 들어가는 서비스 클래스
 * @author MyeongDayeon
 *
 */

@Service
public class externalServiceService {

    @Autowired
    externalServiceMapper externalServiceMapper;

    public List<externalService> getAvailableExternalService() {

        return externalServiceMapper.getAvailableExternalService();
    }

    public int insertExternalService(String name,String url) {
        int result = externalServiceMapper.insertExternalService(name,url);

        return result > 0 ? result : 0;
    }

    public boolean getExternalServiceByName(String name) {

        List<externalService> result = externalServiceMapper.getExternalServiceByName(name);
        return result.size() > 0 ? true : false;
    }


    public simpleResponse insertExternalServiceDetail(String externalServiceDetailNames, int externalServiceIdx) {
        int result = externalServiceMapper.insertExternalServiceDetail(externalServiceDetailNames,externalServiceIdx);
//문제
        return result > 0 ? simpleResponse.SUCCESS : simpleResponse.check5;
    }
}
