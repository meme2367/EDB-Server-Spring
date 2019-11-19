package com.example.rest.controller;

import com.example.rest.dto.simpleResponse;
import com.example.rest.model.externalService;
import com.example.rest.model.externalServiceDetail;
import com.example.rest.service.externalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class externalServiceController {
    // 외부서비스입력

    @Autowired
    private final externalServiceService externalServiceService;
/*private :
/ final :
*/

    public externalServiceController(externalServiceService externalServiceService) {
        this.externalServiceService = externalServiceService;
    }

    @GetMapping("/available")
    public List<externalService> getAvailableExternalService() {
        return externalServiceService.getAvailableExternalService();
    }


    // SERVICE PROVIDER가 외부 서비스 등록
////getExternalServiceByName
    // insertExternalService
    //insertExternalServiceDetail
/*
    @PostMapping
    public simpleResponse insertService(@RequestBody externalServiceDetail externalServiceDetail) {
        if (externalServiceDetail == null) {
//등록바디가제대로 안이뤄졋으니 false
            return simpleResponse.check1;
        } else {
                if (externalServiceService.getExternalServiceByName(externalServiceDetail.getExternalService().getName())) {
//이미 외부서비스로 등록이 되어잇는지
                    return simpleResponse.check2;
                } else {
                    int result = externalServiceService.insertService(externalServiceDetail.getExternalService());
                    if (result != 0) {
                        //
                        return externalServiceService.insertServiceDetail(externalServiceDetail);
                    } else {
                        return simpleResponse.check4;
                    }

                }
        }
    }
*/
    @PostMapping
    public simpleResponse insertExternalService(@RequestBody externalServiceDetail externalServiceDetail){

        int externalServiceIdx = externalServiceService.insertExternalService(externalServiceDetail.getName(),externalServiceDetail.getUrl());

        System.out.print("test\n\n");
        System.out.print(externalServiceIdx);
        return externalServiceService.insertExternalServiceDetail(externalServiceDetail.getExternalServiceDetailNames(),externalServiceIdx);

    }
}



/*
        //getExternalServiceByNameAndExternalServiceIdx
        //insertUserExternalService
        @PostMapping(path="/{externalIdx}")


        //getUserExternalServiceByUserIdx
        @GetMapping


//    getUserExternalServiceDetailByUserIdxAndExternalServiceIdx
        @GetMapping(path="/detail/{externalIdx}")




//deleteUserExternalService
        @DeleteMapping("/{externalIdx}")

        //updateUserExternalServiceDetail
        @PutMapping(path="/{externalIdx}/{externalDetailIdx}")

 */


