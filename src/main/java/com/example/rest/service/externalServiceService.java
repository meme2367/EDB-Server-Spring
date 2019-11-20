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
 * [mysql] auto increment 값 초기화
 * SET @COUNT = 0;
 * UPDATE external_service_detail SET idx = @COUNT:=@COUNT+1;
 */

@Service
public class externalServiceService {

    @Autowired
    externalServiceMapper externalServiceMapper;

    public List<externalService> getAvailableExternalService() {

        return externalServiceMapper.getAvailableExternalService();
    }

    public simpleResponse insertExternalService(externalServiceDetail externalServiceDetail){

        externalServiceDetail.
                setExternalServiceIdx(externalServiceMapper.insertExternalService(externalServiceDetail.getExternalService()));

        int result = externalServiceMapper.insertExternalServiceDetail(externalServiceDetail);

        return result > 0 ? simpleResponse.SUCCESS : simpleResponse.FAIL;
    }
}
